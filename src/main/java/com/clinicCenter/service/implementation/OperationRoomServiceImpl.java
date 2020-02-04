package com.clinicCenter.service.implementation;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.Operation;
import com.clinicCenter.model.OperationRoom;
import com.clinicCenter.repository.MedicalExaminationRoomRepository;
import com.clinicCenter.repository.OperationRoomRepository;
import com.clinicCenter.service.OperationRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OperationRoomServiceImpl implements OperationRoomService {

    @Autowired
    private OperationRoomRepository operationRoomRepository;

    @Override
    public List<OperationRoom> getAll() {
        return this.operationRoomRepository.findAll();
    }

    @Override
    public void removeById(Long id) {
        this.operationRoomRepository.deleteById(id);
    }

    @Override
    public OperationRoom getById(Long id) {
        return this.operationRoomRepository.getOne(id);
    }

    @Override
    public int updateRoom(OperationRoom room) {
        return this.operationRoomRepository.updateRoom(room.getId(), room.getName(), room.getNumber());

    }

    @Override
    public void save(OperationRoom room) {
        this.operationRoomRepository.save(room);
    }

    @Override
    public Set<OperationRoom> getRooms(String name, Integer number) {
        return this.operationRoomRepository.getSearched(name.toLowerCase(), number);
    }

    @Override
    public Set<OperationRoom> getRoomsName(String name) {
        return this.operationRoomRepository.getSearchedByName(name.toLowerCase());
    }

    @Override
    public Collection<OperationRoom> getClinicOperationRooms(Long clinicId, String date, String term) throws ParseException {
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
        return operationRoomRepository.getClinicOperationRooms(clinicId, dd, ddd);
    }
}
