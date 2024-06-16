package org.kevin.demo0212.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kevin.demo0212.model.SecretMoment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Kevin.Zng
 * @date 2023/4/22 15:12
 */
@RestController
@Slf4j
public class TestCursor {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @GetMapping("selectCursor")
    public String getCursor() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Map<String, Date> params = this.getDateMap();
            System.out.println("params = " + params);
            Cursor<SecretMoment> cursor = session.selectCursor("org.kevin.demo0212.mapper.SecretMomentMapper.selectByCursor", params);
            Iterator<SecretMoment> momentIterator = cursor.iterator();
            while (momentIterator.hasNext()) {
                SecretMoment sm = momentIterator.next();
                System.out.println("sm.getMoment() = " + sm.getMoment());
            }
        } catch (Exception e) {
            log.error("what happen?", e);
        }

        return "done";
    }

    private Map<String, Date> getDateMap() {
        Map<String, Date> tempMapDate = new HashMap<>();
        tempMapDate.put("startDate", this.getStartOfToday());
        tempMapDate.put("endDate", this.getEndOfToday());

        return tempMapDate;
    }

    private Date getStartOfToday() {
        LocalDate now = LocalDate.now();
        LocalDateTime startOfDay = now.atStartOfDay();
        return convertLocalDateTime2Date(startOfDay);
    }

    private Date getEndOfToday() {
        LocalDate now = LocalDate.now().plusDays(1);
        LocalDateTime endOfDay = now.atStartOfDay().minusSeconds(1);
        return convertLocalDateTime2Date(endOfDay);
    }

    private Date convertLocalDateTime2Date(LocalDateTime ldt) {
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }
}
