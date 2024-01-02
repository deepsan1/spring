package com.example.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.Entity.MoviesMongoEntity;

import jakarta.servlet.http.HttpServletResponse;

public class PaginatedResultsRetrievedEvent extends ApplicationEvent{
	private UriComponentsBuilder uriBuilder;
	private HttpServletResponse response; 
	private Class clazz; 
	private int page;
	private int totalPages;
	private int pageSize;
	
	public PaginatedResultsRetrievedEvent(final Class<MoviesMongoEntity> class1, final UriComponentsBuilder uriBuilder2, final HttpServletResponse response2, final int page, final int totalPages, final int pageSize) {
		  super(class1);
		  this.clazz = class1;
		  this.uriBuilder = uriBuilder2;
		  this.response = response2;
		  this.page = page;
		  this.totalPages = totalPages;
		  this.pageSize = pageSize;
	}

	public UriComponentsBuilder getUriBuilder() {
		return uriBuilder;
	}

	public void setUriBuilder(UriComponentsBuilder uriBuilder) {
		this.uriBuilder = uriBuilder;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
