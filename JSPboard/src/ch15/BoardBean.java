package ch15;

import lombok.Data;

@Data
public class BoardBean {
	private int num;
	private String name;
	private String subject;
	private String content;
	private int pos;
	private int depth;
	private int ref;
	private String regdate;
	private String pass;
	private String ip;
	private int count;
	private String filename;
	private int filesize;
}
