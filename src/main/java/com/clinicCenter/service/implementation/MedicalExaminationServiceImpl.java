package com.clinicCenter.service.implementation;

import com.clinicCenter.controller.EmailController;
import com.clinicCenter.model.*;
import com.clinicCenter.repository.*;
import com.clinicCenter.service.EmailService;
import com.clinicCenter.service.MedicalExaminationService;
import com.clinicCenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MedicalExaminationServiceImpl implements MedicalExaminationService {

    @Autowired
    private MedicalExaminationRepository medicalExaminationRepository;

    @Autowired
    private MedicalExaminationRequestRepository medicalExaminationRequestRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private OperationRequestRepository operationRequestRepository;

    @Autowired
    private MedicalExaminationTypeRepository medicalExaminationTypeRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MedicalExaminationRoomRepository medicalExaminationRoomRepository;

    @Autowired
    private EmailController emailController;

    @Autowired
    UserService userService;

    int[] daysInAMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    @Override
    public void sendRequest(Long typeId, Date date, Long clinicId, Long doctorId, Long patientId) {
        MedicalExaminationType type = medicalExaminationTypeRepository.findById(typeId).get();
        System.out.println("preuzet tip id : " + type.getId());
        Clinic clinic = clinicRepository.findById(clinicId).get();
        System.out.println("preuzet clinic id : " + clinic.getId());
        User doctor = userRepository.findById(doctorId).get();
        System.out.println("preuzet doktor id : " + doctor.getId());
        User patient = userRepository.findById(patientId).get();
        System.out.println("preuzet pacijent id : " + patient.getId());

        MedicalExaminationRequest newReq = new MedicalExaminationRequest(type, date, clinic, (Doctor) doctor, (Patient) patient);
        medicalExaminationRequestRepository.save(newReq);
    }

    @Override
    public Collection<MedicalExaminationRequest> getAllExaminationRequests(Long adminId) {
        return medicalExaminationRequestRepository.getRequestForClinic(adminId);
    }

    @Override
    public MedicalExaminationRequest getById(Long requestId) {
        return medicalExaminationRequestRepository.findById(requestId).get();
    }

    @Override
    public void saveExamination(Date date, Double price, Double duration, Double discount, Long roomId, Long clinicId, Long doctorId, Long patientId, Long typeId, Long requestId, Boolean predefined) {

        MedicalExaminationType type = medicalExaminationTypeRepository.findById(typeId).get();
        System.out.println("preuzet tip id : " + type.getId());
        Clinic clinic = clinicRepository.findById(clinicId).get();
        System.out.println("preuzet clinic id : " + clinic.getId());
        User doctor = userRepository.findById(doctorId).get();
        System.out.println("preuzet doktor id : " + doctor.getId());

        User patient = null;
        if (patientId != null) {
            patient = userRepository.findById(patientId).get();
            System.out.println("preuzet pacijent id : " + patient.getId());
        }

        MedicalExaminationRoom room = medicalExaminationRoomRepository.findById(roomId).get();
        System.out.println("preuzet room ud : " + room.getId());

        MedicalExamination newExam = new MedicalExamination(date, price, duration, discount, room, (Doctor) doctor, (Patient) patient, clinic, type, predefined);
        this.medicalExaminationRepository.save(newExam);

        if (requestId != null) {
            this.medicalExaminationRequestRepository.deleteById(requestId);
            String message = "You have scheduled an examination : " +
                    "\n Date : " + newExam.getDate() +
                    "\n Clinic : " + newExam.getClinic().getName() + " , " + newExam.getClinic().getAddress() + " , " + newExam.getClinic().getCity() +
                    "\n Doctor : " + newExam.getDoctor().getFirstName() + " " + newExam.getDoctor().getLastName() +
                    "\n Examination type : " + newExam.getType().getName() +
                    "\n Examination room : " + newExam.getMedicalExaminationRoom().getName() + " " + newExam.getMedicalExaminationRoom().getNumber() +
                    "\n Price : " + newExam.getPrice() +
                    "\n Discount : " + newExam.getDiscount() +
                    "\n Duration : " + newExam.getDuration() +
                    "\n  " +
                    "\n Confirm : " + "http://localhost:4200/confirmScheduledExamination/" + newExam.getId() +
                    "\n Decline : " + "http://localhost:4200/declineScheduledExamination/" + newExam.getId();

            String message2 = "You have an examination scheduled : " +
                    "\n Date : " + newExam.getDate() +
                    "\n Clinic : " + newExam.getClinic().getName() + " , " + newExam.getClinic().getAddress() + " , " + newExam.getClinic().getCity() +
                    "\n Patient : " + newExam.getPatient().getFirstName() + " " + newExam.getPatient().getLastName() +
                    "\n Examination type : " + newExam.getType().getName() +
                    "\n Examination room : " + newExam.getMedicalExaminationRoom().getName() + " " + newExam.getMedicalExaminationRoom().getNumber() +
                    "\n Duration : " + newExam.getDuration();

            emailController.sendMail(patient.getEmail(), message, "Automated mail : Confirm or decline scheduled examination.");
            emailController.sendMail(doctor.getEmail(), message2, "Automated mail : Scheduled examination.");

        }

    }

    @Override
    public void confirmScheduledExamination(Long id) {
        medicalExaminationRepository.confirm(id);
    }

    @Override
    public void declineScheduledExamination(Long id) {
        medicalExaminationRepository.deleteById(id);
    }

    @Override
    public void removeMedicalExaminationRequestById(Long i) {
        medicalExaminationRequestRepository.deleteById(i);
    }

    @Override
    public List<MedicalExaminationRequest> getAllExamsRequests() {
        return medicalExaminationRequestRepository.findAll();
    }

    @Override
    public Collection<MedicalExamination> getAllPredefinedMedicalExaminations() {
        return medicalExaminationRepository.getAllPredefinedMedicalExaminations();
    }

    @Override
    public void schedulePredefinedMedicalExamination(Long examinationId, Long patientId) {
        medicalExaminationRepository.schedulePredefinedMedicalExamination(examinationId, patientId);
        MedicalExamination examination = medicalExaminationRepository.findById(examinationId).get();

        String message = "You have scheduled an examination : " +
                "\n Date : " + examination.getDate() +
                "\n Clinic : " + examination.getClinic().getName() + " , " + examination.getClinic().getAddress() + " , " + examination.getClinic().getCity() +
                "\n Doctor : " + examination.getDoctor().getFirstName() + " " + examination.getDoctor().getLastName() +
                "\n Examination type : " + examination.getType().getName() +
                "\n Examination room : " + examination.getMedicalExaminationRoom().getName() + " " + examination.getMedicalExaminationRoom().getNumber() +
                "\n Price : " + examination.getPrice() +
                "\n Discount : " + examination.getDiscount() +
                "\n Duration : " + examination.getDuration() +
                "\n  ";

        emailController.sendMail(examination.getPatient().getEmail(), message, "Automated mail : You have scheduled examination");

    }

    @Override
    public Collection<MedicalExamination> getAllExaminationsPatientCanRate(Long patientId) {
        return medicalExaminationRepository.getAllExaminationsPatientCanRate(patientId);
    }

    @Override
    public void rateDoctor(Long examId) {
        medicalExaminationRepository.rateDoctor(examId);
    }

    @Override
    public void rateClinic(Long examId) {
        medicalExaminationRepository.rateClinic(examId);
    }

    @Override
    public Collection<MedicalExamination> getAllExaminationsFromDoctor(Long id) {
        return medicalExaminationRepository.getAllFromDoctor(id);
    }

    @Override
    public List<Integer> getAllExaminationsDaily(Long id) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 4; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.HOUR, 0);
            cal.add(Calendar.DATE, 1 - i);
            Date end = cal.getTime();
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(new Date());
            cal2.set(Calendar.MINUTE, 0);
            cal2.set(Calendar.HOUR, 0);
            cal2.add(Calendar.DATE, 1 - i - 1);
            Date start = cal2.getTime();
            int broj = this.medicalExaminationRepository.getExamsBetween(id, start, end);
            list.add(broj);
        }
        return list;
    }


    @Override
    public Collection<MedicalExamination> getDoctorsExaminationsByIdAndDate(Long doctorId, Date date1, Date date2) {
        return medicalExaminationRepository.getDoctorsExaminationsByIdAndDate(doctorId, date1, date2);
    }

    @Override
    public MedicalExamination getExamById(Long examId) {
        return medicalExaminationRepository.findById(examId).get();
    }

    @Override
    public Collection<User> getAvailableDoctorsForOperation(Date date1, Date date2, Long clinicId, Long doctorId) {
        return userRepository.getAvailableDoctorsForOperation(date1, date2, clinicId, doctorId);
    }

    @Override
    public Boolean canStartExam(Long patientId, Long doctorId) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE,30);
        Date end = cal.getTime();
        cal.add(Calendar.HOUR, -1);
        Date start = cal.getTime();
        int broj = this.medicalExaminationRepository.canStartExam(start,end,patientId,doctorId);
        if(broj == 0) {
            return true;
        }
        else {
            return false;
        }


    }

    @Override
    public Boolean pastExam(Long patientId, Long doctorId) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        Date end = cal.getTime();
        int broj = this.medicalExaminationRepository.examInPast(end,patientId,doctorId);
        if(broj == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean nurseAndPatient(Long patientId, Long nurseId) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        Date end = cal.getTime();
        int broj = this.medicalExaminationRepository.nurseAndPatient(end,patientId,nurseId);
        if(broj == 0) {
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public MedicalExamination examDoctorPatient(Long patientId, Long doctorId) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE,30);
        Date end = cal.getTime();
        cal.add(Calendar.HOUR, -1);
        Date start = cal.getTime();
        return this.medicalExaminationRepository.getStartExam(start,end,patientId,doctorId);
    }

    @Override
    public Collection<String> getAvailableTermsForDoctor(Long doctorId, String date) throws ParseException {
        date = date.replace('_', '/');
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
        System.out.println(date1);

        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.DATE, 1); //same with c.add(Calendar.DAY_OF_MONTH, 1);
        Date date2 = c.getTime();
        System.out.println(date2);

        Doctor doctor = (Doctor) userService.getById(doctorId);
        Collection<MedicalExamination> examinationsForDoctor = this.getDoctorsExaminationsByIdAndDate(doctorId, date1, date2);
        Collection<MedicalExaminationRequest> examinationRequestsForDoctor = medicalExaminationRequestRepository.getDoctorsExaminationRequestsByIdAndDate(doctorId, date1, date2);
        Collection<Operation> operationsForDoctor = operationRepository.getDoctorsOperationsByIdAndDate(doctorId, date1, date2);
        Collection<OperationRequest> operationRequestForDoctor = operationRequestRepository.getDoctorsOperationRequests(doctorId, date1, date2);
        Collection<Operation> operationDoctorAttends = operationRepository.getDoctorsOperationAttend(doctorId, date1, date2);
        System.out.println("ovo je iz de prisustvuuje" + operationDoctorAttends.size());

        Collection<String> availableTerms = new ArrayList<String>();

        int startWork = doctor.getStartWork();
        int endWork = doctor.getEndWork();

        for (int i = startWork; i < endWork; i++) {
            for (int j = 0; j < 5; j += 3) {
                String part1 = "";
                if (i < 10) {
                    part1 = "0";
                } else {
                    part1 = "";
                }
                availableTerms.add(part1 + i + ":" + j + "0");
            }
        }

        System.out.println("Svi termini za ovog doktora su " + availableTerms);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");
        for (MedicalExamination examination : examinationsForDoctor) {
            String dateAndTime = formatter.format(examination.getDate());
            String time = dateAndTime.split(" ")[1].substring(0, 5);
            availableTerms.remove(time);
        }

        for (MedicalExaminationRequest request : examinationRequestsForDoctor) {
            String dateAndTime = formatter.format(request.getDate());
            String time = dateAndTime.split(" ")[1].substring(0, 5);
            availableTerms.remove(time);
        }

        for (Operation operation : operationsForDoctor) {
            String dateAndTime = formatter.format(operation.getDate());
            String time = dateAndTime.split(" ")[1].substring(0, 5);
            availableTerms.remove(time);
        }

        for (OperationRequest operationRequest : operationRequestForDoctor) {
            String dateAndTime = formatter.format(operationRequest.getDate());
            String time = dateAndTime.split(" ")[1].substring(0, 5);
            availableTerms.remove(time);
        }

        for (Operation operation : operationDoctorAttends) {
            String dateAndTime = formatter.format(operation.getDate());
            System.out.println("vrimeeeeee" + dateAndTime);
            String time = dateAndTime.split(" ")[1].substring(0, 5);
            availableTerms.remove(time);
        }

        System.out.println("Svi slobodni termini za ovog doktora su" + availableTerms);

        return availableTerms;
    }

    @Override
    public List<Integer> getAllExaminationsMonthly(Long id) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 4; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.HOUR, 23);
            cal.add(Calendar.MONTH, 0 - i);
            cal.set(Calendar.DATE, this.daysInAMonth[cal.get(Calendar.MONTH)]);
            Date end = cal.getTime();
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(new Date());
            cal2.set(Calendar.MINUTE, 0);
            cal2.set(Calendar.HOUR, 0);
            cal2.set(Calendar.DATE, 1);
            cal2.add(Calendar.MONTH, 0 - i);
            Date start = cal2.getTime();
            int broj = this.medicalExaminationRepository.getExamsBetween(id, start, end);
            list.add(broj);
        }
        return list;
    }

    @Override
    public List<Integer> getAllExaminationsYearly(Long id) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 4; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.set(Calendar.MINUTE, 56);
            cal.set(Calendar.HOUR, 23);
            cal.set(Calendar.MONTH, Calendar.DECEMBER);
            cal.set(Calendar.DATE, 30);
            cal.add(Calendar.YEAR, 0 - i);
            Date end = cal.getTime();
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(new Date());
            cal2.set(Calendar.MINUTE, 0);
            cal2.set(Calendar.HOUR, 0);
            cal2.set(Calendar.DATE, 1);
            cal2.set(Calendar.MONTH, Calendar.JANUARY);
            cal2.add(Calendar.YEAR, 0 - i - 1);

            Date start = cal2.getTime();
            int broj = this.medicalExaminationRepository.getExamsBetween(id, start, end);
            list.add(broj);
        }
        return list;        }

    @Override
    public List<Long> getIncomes(Long id) {
        List<Long> list = new ArrayList<Long>();

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.MINUTE, 56);
        cal.set(Calendar.HOUR, 23);
        Date end = cal.getTime();
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.HOUR, 0);
        Date start = cal2.getTime();
        Long incomeDay = this.medicalExaminationRepository.getIncomeBetween(id, start, end);
        list.add(incomeDay);
        cal2.add(Calendar.DATE, -10);
        Date start2 = cal2.getTime();
        Long incomeTen = this.medicalExaminationRepository.getIncomeBetween(id,start2,end);
        list.add(incomeTen);
        cal2.setTime(new Date());
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.HOUR, 0);
        cal2.add(Calendar.MONTH, -1);
        Date start3 = cal2.getTime();
        Long incomeMonth = this.medicalExaminationRepository.getIncomeBetween(id,start3,end);
        list.add(incomeMonth);
        cal2.add(Calendar.MONTH, -2);
        Date start4 = cal2.getTime();
        Long incomeThree = this.medicalExaminationRepository.getIncomeBetween(id,start4,end);
        list.add(incomeThree);
        cal2.add(Calendar.MONTH, -3);
        Date start5 = cal2.getTime();
        Long incomeSix = this.medicalExaminationRepository.getIncomeBetween(id, start5,end);
        list.add(incomeSix);
        cal2.add(Calendar.MONTH, -6);
        Date start6 = cal2.getTime();
        Long incomeYear = this.medicalExaminationRepository.getIncomeBetween(id,start6, end);
        list.add(incomeYear);

        return list;
    }

    @Override
    public Collection<MedicalExamination> getAllExaminationsFromRoom(Long roomId) {
        return medicalExaminationRepository.getAllFromRoom(roomId);
    }
}
