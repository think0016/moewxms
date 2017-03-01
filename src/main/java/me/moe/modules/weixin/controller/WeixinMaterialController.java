package me.moe.modules.weixin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.jfinal.aop.Before;
import com.jfinal.upload.UploadFile;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.MediaApi;

import me.moe.common.utils.CommonTools;
import me.moe.common.utils.MoeFileUtils;
import me.moe.model.User;
import me.moe.modules.weixin.interceptor.VerifyCurrentPublic;
import me.moe.modules.weixin.model.Attachment;
import me.moe.modules.weixin.model.MaterialImage;
import me.moe.modules.weixin.model.MaterialText;
import me.moe.modules.weixin.model.Public;
import me.moe.modules.weixin.service.AttachmentService;
import me.moe.modules.weixin.service.MaterialImageService;
import me.moe.modules.weixin.service.MaterialTextService;

/**
 * 素材管理控制器
 * 
 * @author liu
 *
 */
public class WeixinMaterialController extends WeixinBaseController {
	private MaterialTextService materialTextService = new MaterialTextService();
	private MaterialImageService materialImageService = new MaterialImageService(); 
	private AttachmentService attachmentService = new AttachmentService();
	private Gson gson = new Gson();

	@Before({ VerifyCurrentPublic.class })
	public void index() {
//		String type = getPara(0);
//		
//		String tab = "1";
//		
//		if(StringUtils.isNotEmpty(type)){
//			if("text".equals(type)){
//				tab = "5";
//			}else if("image".equals(type)){
//				tab = "2";
//			}
//		}
//		setAttr("tab", tab);
//		render("index.html");
		redirect("/weixin/material/list");
	}

	@Before({ VerifyCurrentPublic.class })
	public void list() {
		String type = getPara(0);
		
		String tab = "1";
		
		if(StringUtils.isNotEmpty(type)){
			if("text".equals(type)){
				tab = "5";
			}else if("image".equals(type)){
				tab = "2";
			}
		}
		
		// List<MaterialText> mtextlist=
		// materialTextService.findListByToken(this.current_token);
		setAttr("tab", tab);
		render("index.html");
	}

	@Before({ VerifyCurrentPublic.class })
	public void getmlist() {
		// Public publicapp =
		// (Public)getSession().getAttribute("cache_wxpublic");
		// if(publicapp == null){
		// System.out.println("publicapp is null");
		// }else{
		// System.out.println("publicapp is NOT null");
		// }

		String type = getPara("type");
		// DatatablesArray datatablesArray = new DatatablesArray();
		List<String[]> rs = new ArrayList<String[]>();
		if ("text".equals(type)) {
			rs = materialTextService.gettabledataArray(this.current_token);
			// datatablesArray.setData(rs);

		} else if ("image".equals(type)) {

		} else if ("voice".equals(type)) {

		} else if ("video".equals(type)) {

		} else if ("news".equals(type)) {

		}

		renderText(gson.toJson(rs));

	}

	@Before({ VerifyCurrentPublic.class })
	public void textform() {
		String materialid = getPara(0);
		String subtitle = "添加文本素材";
		String update = "0";
		
		MaterialText mt = new MaterialText();
		if(StringUtils.isNotEmpty(materialid)){
			subtitle = "修改文本素材";
			update = "1";
			mt = materialTextService.findMaterialTextById(materialid);
		}
		
		setAttr("update", update);
		setAttr("materialText", mt);
		setAttr("subtitle", subtitle);
		
		render("textform.html");
	}

	@Before({ VerifyCurrentPublic.class })
	public void savetextmaterial() {
		Public publicapp = (Public) getSession().getAttribute("cache_wxpublic");
		User cuser = (User) getSession().getAttribute("cache_user");
		boolean flag = false;

		String mid = getPara("mid");
		String update = getPara("update");
		String mname = getPara("mname");
		String content = getPara("content");
		Date createdate = new Date();
		// String createdate = CommonTools.dateTostring("yyyy-MM-dd HH:mm:ss",
		// new Date());
		if (StringUtils.isEmpty(mname)) {
			mname = "无标题(" + CommonTools.dateTostring("yyyy-MM-dd HH:mm:ss", createdate) + ")";
		}

		MaterialText mt = new MaterialText();
		if("1".equals(update)){
			mt = materialTextService.findMaterialTextById(mid);
			mt.setMname(mname);
			mt.setContent(content);		
			mt.setCreatedate(createdate);
		}else{
			mt.setMname(mname);
			mt.setContent(content);
			mt.setCreatedate(createdate);
			mt.setToken(publicapp.getToken());
			mt.setManagerId(cuser.getUid());
		}

		if ("1".equals(update)) {
			flag = mt.update();
		} else {
			flag = mt.save();
		}
		if (flag) {
			renderText("1");
		} else {
			renderText("0");
		}

	}

	public void deletetextmaterial(){
		String materialid = getPara("id");
		String flag = "0";

		if(StringUtils.isNotEmpty(materialid)){
			if(materialTextService.delete(materialid)){
				flag = "1";
			}
		}
				
		renderText(flag);
	}
	
	@Before({ VerifyCurrentPublic.class })
	public void imageform() {
		setAttr("subtitle", "添加图片素材");

		render("imageform.html");
	}

	@Before({ VerifyCurrentPublic.class })
	public void saveimagematerial() {
		Public publicapp = (Public) getSession().getAttribute("cache_wxpublic");
		User cuser = (User) getSession().getAttribute("cache_user");
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("status", "0");
		result.put("msg", "");
		
		String fileid = getPara("fileid");
		String mname = getPara("mname");
		Date createdate = new Date();
		if (StringUtils.isEmpty(mname)) {
			mname = "无标题(" + CommonTools.dateTostring("yyyy-MM-dd HH:mm:ss", createdate) + ")";
		}
		
		if (StringUtils.isNotEmpty(fileid)) {
			String[] fileid_arr = StringUtils.split(fileid, ";");
			for (int i = 0; i < fileid_arr.length; i++) {
				//String cover_id = 
				String attachment_id = fileid_arr[i];
				//attachment_id = attachmentService.
				Attachment attachment= attachmentService.findAttachmentById(attachment_id);
				File file = new File(attachment.getPath());
				ApiResult ar = MediaApi.addMaterial(file);
				if(ar.isSucceed()){
					//上传服务器成功
					String arjson = ar.getJson();
					HashMap<String,String> arobj = gson.fromJson(arjson, HashMap.class);
					String media_id = arobj.get("media_id");
					String wechat_url = arobj.get("url");
					
					//materialImageService.
					
					MaterialImage materialImage = new MaterialImage();
					
				}else{
					result.put("msg", ar.getErrorMsg());
				}
				
				//MaterialImage materialImage = new MaterialImage();
				
			}
		}else{
			result.put("msg", "图片文件不能为空");
		}

		Gson gson = new Gson();
		String json = gson.toJson(result);
		renderText(json);
	}

	public void uploadfile() {
		User cuser = (User) getSession().getAttribute("cache_user");
		String uploadtype = getPara(0);

		Map<String, String> result = new HashMap<String, String>();
		result.put("status", "0");
		result.put("msg", "");

		if ("image".equals(uploadtype)) {
			UploadFile uf = getFile("uploadimage");

			// 设置保存路径
//			String rootpath = JFinal.me().getServletContext().getRealPath("upload/weixin") + File.separatorChar;
//			String middlepath = CommonTools.dateTostring("yyyyMMdd", new Date());
//			String path = rootpath + middlepath + File.separatorChar;
//			String filename = ((User) getSession().getAttribute("cache_user")).getUid().toString() + "_"
//					+ (new Date().getTime()) + "." + MoeFileUtils.getExtname(uf.getOriginalFileName());
			
			String filename = MoeFileUtils.createfilename(cuser.getUid().toString(), MoeFileUtils.getExtname(uf.getOriginalFileName()));
			Map<String,String> pathinfo = this.getUploadPathInfo(filename);
			
			if (MoeFileUtils.isImg(uf.getContentType())) {

				File srcFile = uf.getFile();
				File destFile = new File(pathinfo.get("path"));

				try {
					// 调整尺寸
					// MoeFileUtils.resizeImage(srcFile, srcFile, 160, 160);
					FileUtils.moveFile(srcFile, destFile);

					Attachment attachment = new Attachment();
					attachment.setExt(MoeFileUtils.getExtname(uf.getOriginalFileName()));
					attachment.setCreatedate(new Date());
					attachment.setUrl(pathinfo.get("url"));
					attachment.setFilename(filename);
					attachment.setPath(pathinfo.get("path"));
					attachment.setManagerId(cuser.getUid());
					long id = attachmentService.save(attachment);

					result.put("status", "1");
					result.put("fileId", new Long(id).toString());
					result.put("msg", pathinfo.get("url"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				result.put("msg", "图片上传格式不正确");
			}
		}

		Gson gson = new Gson();
		String json = gson.toJson(result);
		renderText(json);
	}
}