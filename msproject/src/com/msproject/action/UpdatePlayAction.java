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

public class UpdatePlayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename= " ";
		int filesize = 0;
		
		File uploadDir = new File(Constants.UPLOAD_PATH);
		if(!uploadDir.exists()) {	// 저장할 경로가 없다면
			uploadDir.mkdir();		// 디렉토리 생성
		}
		
		// 파일 업로드 2) "D:\\upload"로 첨부파일 저장
		// 기본파일이 있든 없든 새로운 파일 저장
		// ex) 만약에 기존 파일이 aaa.txt가 있고
		//		새로 등록하는 첨부파일이 bbb.txt가 있다면
		//		현재 upload 디렉토리에는 aaa.txt,bbb.txt두개가 있음
		MultipartRequest multi = new MultipartRequest(request,
				Constants.UPLOAD_PATH,	// 파일업로드 디렉토리
				Constants.MAX_UPLOAD,	// 업로드 최대 용량 
				"UTF-8",				// 인코딩
				new DefaultFileRenamePolicy());	//파일이름 중복정책
		String bno = multi.getParameter("bno");
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		String basic_check = multi.getParameter("basic_check");
			
		BoardDAO bDao = BoardDAO.getInstance();
		BoardDTO bDto = bDao.view(bno);
		
		boolean basicFileDelete = true;
		if(basic_check.equals("no")) {
			basicFileDelete = false;
		}else {
			filename = bDto.getFilename();
			filesize = bDto.getFilesize();
		}
		
		if(!basicFileDelete) {
			filename = bDto.getFilename();
			File file = new File(Constants.UPLOAD_PATH+filename);
			file.delete();
		}
		
		// 새로 등록한 첨부파일이 있다면
		// 새로 등록한 첨부파일의 filename과 filesize를 구하고
		// 새로 등록한 첨부파일이 없다면
		// : while()을 타지않아
		// : filename = " ", filesize = 0으로 고정
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
		
		
		if(filename == null || filename.trim().equals("")) {
			// 새로등록한 첨부파일 없는 경우
			filename = "-";
		}
		bDto.setTitle(title);
		bDto.setContent(content);
		bDto.setFilename(filename);
		bDto.setFilesize(filesize);
		System.out.println(bDto.toString());
		bDao.updateBoard(bDto);
		
		String url = "boardView.ms?bno="+bno;
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		return forward;
	}

}
