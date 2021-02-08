package com.gura.spring05.file.dao;

import java.util.List;

import com.gura.spring05.file.dto.FileDto;

public interface FileDao {
	// 전체 글의 갯수를 리턴
	public int getCount(FileDto dto);
	// 파일 삭제
	public void delete(int num);
	// 파일 추가
	public void insert(FileDto dto);
	// 하나의 파일 정보
	public FileDto getData(int num);
	// 파일 목록 전체 리턴
	public List<FileDto> getList(FileDto dto);
}
