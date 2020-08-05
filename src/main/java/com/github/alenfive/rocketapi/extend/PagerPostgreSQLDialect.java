package com.github.alenfive.rocketapi.extend;

import org.springframework.stereotype.Component;

/**
 * sql server 分页构造
 */
@Component
public class PagerPostgreSQLDialect implements IPagerDialect {

    @Override
    public String match() {
        return ":postgresql:";
    }

    @Override
    public String buildCountScript(String script, Integer index, Integer pageSize) {
        return "select count(1) from ("+script+") t1";
    }

    @Override
    public String buildPageScript(String script, Integer offset, Integer limit) {
        return script + " limit "+limit+" offset "+offset;
    }
}