/**
 * 
 */
package com.nabis.ctrls;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nabis.common.JsonUtil;
import com.nabis.svc.JqgridService;

/**
 * @author padoya
 *
 */
@Controller
public class NabisController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("11111");
		return "test";
	}

	@RequestMapping(value="jqgridStartMain.do")
    public void jqgridStartMain(HttpServletRequest request, HttpServletResponse response, @ModelAttribute JqgridService jqgridVo, ModelMap model) {
        PrintWriter out = null;
        
        response.setCharacterEncoding("UTF-8");
        
        String quotZero = request.getParameter("param");
        System.out.println(quotZero);
        quotZero = quotZero.replaceAll("&quot;", "\"");
        System.out.println(quotZero);
        
        Map<String, Object> castMap = new HashMap<String, Object>();
        
        castMap = JsonUtil.JsonToMap(quotZero); // quotZero json을 맵으로 변환시킨다.

        jqgridVo.setServiceImplYn((String) castMap.get("serviceImplYn"));
                
        List<EgovMap> jqGridList = jqgridVo.selectJqgridList(jqgridVo);
        EgovMap jqGridListCnt = jqgridVo.selectJqgridListCnt(jqgridVo);
                
        HashMap<String, Object> resMap = new HashMap<String, Object>();
                
        resMap.put("records", jqGridListCnt.get("toatalTotCnt"));
        resMap.put("rows", jqGridList);
        resMap.put("page", request.getParameter("page"));
        System.out.println("page from request "+request.getParameter("page"));
        resMap.put("total", jqGridListCnt.get("totalpage"));
                
        out = response.getWriter();
                
        out.write(JsonUtil.HashMapToJson(resMap).toString());
    }
}
