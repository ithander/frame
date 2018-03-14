package org.ithang.tools.model;

import java.util.List;

public class Page<T> {

	private long pageNow;//当前页号,分页必传，不传的话默认为0，如果传0表示不分页
	private long pageSize=20;//每页记录数
	private long pageNum;//总页数
	private long total;//总记录数
	private long from;//从指定记录查
	private String order;//排序字段
	private String sort;//排序算法asc|desc
	private List<T> data;
	
	public Page(long pageNow,long pageSize){
		setPageNow(pageNow);
		setPageSize(pageSize);
	}
	
	public long getPageNow() {
		return pageNow;
	}
	public void setPageNow(long pageNow) {
		this.pageNow = pageNow;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public long getPageNum() {
		return pageNum;
	}
	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getFrom() {
		return from;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public void setFrom(long from) {
		this.from = from;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
