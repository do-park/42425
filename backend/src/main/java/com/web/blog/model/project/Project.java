package com.web.blog.model.project;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class Project {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
	
	@JoinColumn(name="user_uid")
	private int uid;
	
	private String title;
	private String content;
	private String summary;
	
	@Column(insertable = false, updatable = true, nullable=true)
	private String nickname;
	

	@Column(name="write_date", insertable = false, updatable = false)
	private LocalDateTime writeDate;
}
