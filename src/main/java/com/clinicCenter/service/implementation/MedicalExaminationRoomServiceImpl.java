package com.clinicCenter.service.implementation;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.repository.MedicalExaminationRoomRepository;
import com.clinicCenter.service.MedicalExaminationRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class MedicalExaminationRoomServiceImpl implements MedicalExaminationRoomService {

    @Autowired
    private MedicalExaminationRoomRepository medicalExaminationRoomRepository;

    @Override
    public List<MedicalExaminationRoom> getAll() {
        return this.medicalExaminationRoomRepository.findAll();
    }

    @Override
    public MedicalExaminationRoom getById(Long id) {
        return this.medicalExaminationRoomRepository.getOne(id);
    }

    @Override
    public void removeById(Long id) {
        this.medicalExaminationRoomRepository.deleteById(id);
    }

    @Override
    public int updateRoom(MedicalExaminationRoom room) {
        return this.medicalExaminationRoomRepository.updateRoom(room.getId(), room.getName(), room.getNumber());
    }

    @Override
    public void save(MedicalExaminationRoom room) {
        this.medicalExaminationRoomRepository.save(room);
    }

    @Override
    public Set<MedicalExaminationRoom> getRooms(String name, Integer number) {
        return this.medicalExaminationRoomRepository.getSearched(name.toLowerCase(), number);
    }

    @Override
    public Set<MedicalExaminationRoom> getRoomsName(String name) {
        return this.medicalExaminationRoomRepository.getSearchedByName(name.toLowerCase());
    }

    @Override
    public Set<MedicalExaminationRoom> getClinicRooms(Long clinicAdminId, String date, String term) throws ParseException {
        date = date.replace('_', '/');
        date = date.split(" ")[0];
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
        System.out.println(date1);

        Calendar cal = Calendar.getInstance();

        String[] time = term.split(":");
        String hours = time[0];
        String minutes = time[1];

        cal.setTime(date1);
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
        cal.set(Calendar.MINUTE, Integer.parseInt(minutes) - 2);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date dd = cal.getTime();
        System.out.println(dd);

        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
        cal.set(Calendar.MINUTE, Integer.parseInt(minutes) + 2);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date ddd = cal.getTime();
        System.out.println(ddd);

        return medicalExaminationRoomRepository.getClinicRooms(clinicAdminId, dd, ddd);
    }

    @Override
    public List<MedicalExaminationRoom> getAvailableRooms(Long id, Date date) {
        return medicalExaminationRoomRepository.getAvailableRooms(id, date);
    }
}

