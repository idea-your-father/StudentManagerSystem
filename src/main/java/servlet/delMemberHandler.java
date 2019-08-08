package servlet;

import bean.Member;
import dao.Dao;
import dao.daoImpl.MemberDao;
import org.json.JSONObject;
import util.QueryRunnerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ASUS on 2019/8/6.
 *
 * 用来处理删除成员的事务
 *
 *
 */
@WebServlet(name = "Servlet",urlPatterns = "/del.do")
public class delMemberHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id= request.getParameter("id");
        System.out.println(id);
        Dao dao = MemberDao.getInstance();

        Member m = new Member();
        m.setId(id);
        JSONObject jsonObject = null;
        try
        {
            dao.del(m);
            jsonObject = new JSONObject("{delAns:true}");
        }catch (Exception e) {
            e.printStackTrace();
            jsonObject = new JSONObject("{delAns:false}");
        }finally {
            response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }




}
