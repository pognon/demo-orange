package fr.company.demo.service.mobile.request.dto;

import org.apache.commons.lang.StringUtils;

public class ItemQueryDto extends QueryDto {
    private String id;

    public Integer getIntId() {
        return StringUtils.isNumeric(id) ? Integer.parseInt(id) : null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
