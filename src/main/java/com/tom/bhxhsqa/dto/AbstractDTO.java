package com.tom.bhxhsqa.dto;

public class AbstractDTO<T> {
    private Long id;
//	private String createdBy;
//	private String createdDate;
//	private String modifiedBy;
//	private Date modifiedDate;
//	private List<T> listResult = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}