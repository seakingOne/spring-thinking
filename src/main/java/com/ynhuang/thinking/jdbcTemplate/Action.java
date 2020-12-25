package com.ynhuang.thinking.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author YuHuang
 */
@Service
public class Action {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void test() throws InterruptedException {
        String setSchema = String.format("SET SCHEMA '%s'", "t_test002");
        this.jdbcTemplate.execute(setSchema);

        Thread.sleep(5000);

        // other action
        otherAction();
    }

    @Transactional
    public int otherAction() {

        System.out.println("current_schema is : " + jdbcTemplate.queryForObject("select current_schema();", null, String.class));

        String sql = "select guid from currency where 1=1 and code='PKR'";

        this.jdbcTemplate.execute(sql);

        return 1;

    }

}
