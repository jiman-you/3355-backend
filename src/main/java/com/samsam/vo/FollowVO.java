package com.samsam.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="follows")
@Entity 
@Data
public class FollowVO {//팔로우 브이오
	@EmbeddedId 
	private FollowId follow;//팔로우 복합키를 받아와서 아이디로 함
	
}
