package com.msproject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msproject.action.Action;
import com.msproject.action.ActionForward;
import com.msproject.action.GoodAjaxAction;
import com.msproject.action.GoodSwitchAjaxAction;
import com.msproject.action.InsertAction;
import com.msproject.action.BoardListAction;
import com.msproject.action.BoardViewAction;
import com.msproject.action.CommentListAction;
import com.msproject.action.ConstractAction;
import com.msproject.action.DownloadAction;
import com.msproject.action.DropMemberAction;
import com.msproject.action.DropMemberPlayAction;
import com.msproject.action.IdCheckAction;
import com.msproject.action.IndexAction;
import com.msproject.action.InfoUpdateAction;
import com.msproject.action.InfoUpdatePlayAction;
import com.msproject.action.InsertPlayAction;
import com.msproject.action.JoinAction;
import com.msproject.action.JoinPlayAction;
import com.msproject.action.LoginAjaxAction;
import com.msproject.action.LogoutAction;
import com.msproject.action.LogoutAjaxAction;
import com.msproject.action.PwCheckAjaxAction;
import com.msproject.action.PwUpdatePlayAction;
import com.msproject.action.RegisterAjaxAction;
import com.msproject.action.ReplyAddAction;
import com.msproject.action.ReplyRemoveAction;
import com.msproject.action.UpdateAction;
import com.msproject.action.RemovePlayAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Action action = null;
		ActionForward forward = null;
		
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		System.out.println("페이지 이동 ===>"+ command);
		
		if(command.equals("/index.ms")) {
			action = new IndexAction();
			forward = action.execute(request, response);
		}else if(command.equals("/constract.ms")) {
			action = new ConstractAction();
			forward = action.execute(request, response);			
		}else if(command.equals("/join.ms")) {
			action = new JoinAction();
			forward = action.execute(request, response);
		}else if(command.equals("/idCheck.html")) {
			action = new IdCheckAction();
			forward = action.execute(request, response);
		}else if(command.equals("/joinPlay.ms")) {
			action = new JoinPlayAction();
			forward = action.execute(request, response);
		}else if(command.equals("/login.ms")) {
			action = new LoginAjaxAction();
			forward = action.execute(request, response);
		}else if(command.equals("/logOut.ms")) {
			action = new LogoutAction();
			forward = action.execute(request, response);
		}else if(command.equals("/logoutAjax.ms")){
			action = new LogoutAjaxAction();
			forward = action.execute(request, response);
		}else if(command.equals("/infoUpdate.ms")){
			action = new InfoUpdateAction();
			forward = action.execute(request, response);
		}else if(command.equals("/infoUpdatePlay.ms")){
			action = new InfoUpdatePlayAction();
			forward = action.execute(request, response);
		}else if(command.equals("/pwUpdatePlay.ms")) {
			action = new PwUpdatePlayAction();
			forward = action.execute(request, response);
		}else if(command.equals("/dropMember.ms")) {
			action = new DropMemberAction();
			forward = action.execute(request, response);
		}else if(command.equals("/pwCheckAjax.ms")) {
			action = new PwCheckAjaxAction();
			forward = action.execute(request, response);
		}else if(command.equals("/dropMemberPlay.ms")) {
			action = new DropMemberPlayAction();
			forward = action.execute(request, response);
		}else if(command.equals("/boardInsert.ms")) {
			action = new InsertAction();
			forward = action.execute(request, response);
		}else if(command.equals("/boardList.ms")) {
			action = new BoardListAction();
			forward = action.execute(request, response);
		}else if(command.equals("/boardView.ms")) {
			action = new BoardViewAction();
			forward = action.execute(request, response);
		}else if(command.equals("/commentlist.ms")) {
			action = new CommentListAction();
			forward = action.execute(request, response);
		}else if(command.equals("/boardGood.ms")) {
			action = new GoodAjaxAction();
			forward = action.execute(request, response);
		}else if(command.equals("/boardSwitch.ms")) {
			action = new GoodSwitchAjaxAction();
			forward = action.execute(request, response);
		}else if(command.equals("/replyAdd.ms")) {
			action = new ReplyAddAction();
			forward = action.execute(request, response);
		}else if(command.equals("/replyRemove.ms")) {
			action = new ReplyRemoveAction();
			forward = action.execute(request, response);
		}else if(command.equals("/registerAjax.ms")) {
			action = new RegisterAjaxAction();
			forward = action.execute(request, response);
		}else if(command.equals("/insertPlay.ms")) {
			action = new InsertPlayAction();
			forward = action.execute(request, response);
		}else if(command.equals("/download.ms")) {
			action = new DownloadAction();
			forward = action.execute(request, response);
		}else if(command.equals("/delete.ms")) {
			action = new RemovePlayAction();
			forward = action.execute(request, response);
		}else if(command.equals("/update.ms")) {
			action = new UpdateAction();
			forward = action.execute(request, response);
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}

}
