package com.dw.pjsipweb;

import com.dw.pjsipweb.entity.Room;
import com.dw.pjsipweb.mapper.RoomMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PjsipwebApplicationTests {


    @Autowired
    private RoomMapper roomMapper;

    @Test
    void contextLoads() {
        Room room=new Room();
        room.setDomain("*");
        roomMapper.insert(room);
    }

}
