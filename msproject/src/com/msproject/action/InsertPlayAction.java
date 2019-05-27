package com.msproject.action;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msproject.common.Constants;
import com.msproject.dao.BoardDAO;
import com.msproject.dto.BoardDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class InsertPlayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파일업로드 1) 파일을 저장할 디렉토리 생성
		File uploadDir = new File(Constants.UPLOAD_PATH);
		if(!uploadDir.exists()) {	// 저장할 경로가 없다면
			uploadDir.mkdir();		// 디렉토리 생성
		}
		
		
		// request를 확장시킨 MultipartRequest 생성
		// request는 모두 String 타입
		// 파일 <- request로 전송 불가
		// 파일 <- request를 향상시킨 MultipartRequest를 사용
		// 그래서 파일뿐만 아니라 기존에 String타입도 전부
		// Multipart 타입으로 변경해아함.
		
		String url = "boardList.ms";
		// 파일업로드 2) d:\\upload로 첨부파일 저장
		MultipartRequest multi = new MultipartRequest(request,
				Constants.UPLOAD_PATH,	// 파일업로드 디렉토리
				Constants.MAX_UPLOAD,	// 업로드 최대 용량 
				"UTF-8",				// 인코딩
				new DefaultFileRenamePolicy());	//파일이름 중복정책
		
		BoardDTO bDto = new BoardDTO();
		bDto.setTitle(multi.getParameter("title"));
		bDto.setContent(multi.getParameter("content"));
		bDto.setWriter(multi.getParameter("writer"));
		String filename= " ";
		int filesize = 0;
		
		// 파일업로드 3) DB에 저장할 첨부파일의 이름과 사이즈를 구함
		try {
			Enumeration files = multi.getFileNames();
			while(files.hasMoreElements()) {
				String file1 = (String)files.nextElement();
				filename = multi.getFilesystemName(file1);	//첨부파일의 파일이름
				File f1 = multi.getFile(file1);				//첨부파일의 파일
				
				if(f1!=null) {
					// filesize는 long 타입으로 가져옴
					// int로 형변환
					filesize = (int)f1.length();	//첨부파일의 파일사이즈 저장
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//사용자가 첨부파일을 등록하지 않았을 때
		//파일이름이 null이나 ""으로 들어가는 것을 방지
		//"-"으로 저장되게 변경
		if(filename == null || filename.trim().equals("")) {
			filename = "-";
		}
		
		bDto.setFilename(filename);
		bDto.setFilesize(filesize);
		
		System.out.println(bDto.toString());
		BoardDAO bDao = BoardDAO.getInstance();
		int result = bDao.insertBoard(bDto);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		return forward;
	}
}
