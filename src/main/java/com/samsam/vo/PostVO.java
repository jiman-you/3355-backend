package com.samsam.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//태영
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="posts")
@Entity
@Getter @Setter
@ToString(exclude = "comms")
public class PostVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="POSTS_SEQUENCE_GENERATOR", sequenceName = "POSTS_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "POSTS_SEQUENCE_GENERATOR")
	private Integer postNO;
	@Column(length = 1000)
	private String postImg;
	@UpdateTimestamp
	private Timestamp postDate;
	
	@ManyToOne
	@JoinColumn(name = "user_no")
	private UserVO user;
	
	@OneToMany(mappedBy = "post",
			cascade = CascadeType.ALL,
			fetch=FetchType.EAGER)
	List<CommentVO> comms;
	
	
}
