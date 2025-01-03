package iih.mp.nr.crisisvallistener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import iih.mp.nr.crisisval.d.CrisisValDO;
import iih.mp.nr.crisisval.d.CrisisvalAggDO;
import iih.mp.nr.crisisval.i.ICrisisvalRService;
import iih.mp.nr.i.IMpNrLogService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent.BDCommonUserObj;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.message.task.d.TaskDO;
import xap.sys.message.task.d.TaskUserDO;
import xap.sys.message.task.d.desc.TaskUserDODesc;
import xap.sys.message.task.i.ITaskMDORService;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;
/**
 * 
* @ClassName: ResponseCrisisValMsgListener
* @Description: 监听危急值信息确认任务,确认信息回调第三方接口
* @author zhy
* @date 2019年10月25日
*
 */
public abstract class ResponseCrisisValMsgListener implements IBusinessListener{

	private IMpNrLogService MpNrLog;
	
	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
	    MpNrLog = ServiceFinder.find(IMpNrLogService.class);
		String msg = "\n----危急值消息确认---";
		MpNrLog.apilog(format.format(date) + " " + msg, Level.INFO);
		// 1、验证
		if (!validation(arg0)) {
			return;
		}

		// 2、取参数
		BDCommonUserObj userObj = (BDCommonUserObj) arg0.getUserObject();
		TaskUserDO[] taskUserDOs = (TaskUserDO[]) userObj.getNewObjects();
		
		
		// 3.非危急值的消息不处理
		TaskDO task = ServiceFinder.find(ITaskMDORService.class).findById(taskUserDOs[0].getTaskid());
		if(task == null || !"项目预警值".equals(task.getName())){
			MpNrLog.apilog("\n----危急值消息确认 任务名称【"+task.getName()+"】---",Level.INFO);
			return;
		}
		
		// 4、逻辑处理
		this.handle(task,taskUserDOs[0]);
		
	}
	
	/**
	 * 参数校验
	 * @param arg0
	 * @return
	 */
	private boolean validation(IBusinessEvent arg0) {
		if (TaskUserDODesc.CLASS_FULLNAME.equals(arg0.getSourceID()) && IEventType.TYPE_UPDATE_AFTER.equals(arg0.getEventType())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 逻辑处理
	 * @param task
	 * @throws BizException 
	 */
	private void handle(TaskDO task,TaskUserDO taskUserDO) throws BizException {
		// 1.参数校验
		if (task == null || !"项目预警值".equals(task.getName())) {
			return;
		}
		
		// 2.获取到危急值相关信息
		ICrisisvalRService crisisvalRService = ServiceFinder.find(ICrisisvalRService.class);
		CrisisvalAggDO[] crisisvalAggDOs = crisisvalRService.findByAttrValString(CrisisValDO.ID_TASK, task.getTaskid());
		
		// 3.区分检验检查,调用第三方webservice通知危急值已确认
		if (null == crisisvalAggDOs || crisisvalAggDOs.length < 1) {
			MpNrLog.apilog("\n----危急值消息确认 任务名称【"+task.getName()+"】---无危急值信息",Level.INFO);
			return;
		}
		for (CrisisvalAggDO aggDO : crisisvalAggDOs) {
			if (null != aggDO.getCrisisValLisDO() && aggDO.getCrisisValLisDO().length > 0) {
				 String rtn = packageData(aggDO, taskUserDO);
				 invokeLisServer(rtn);
			} else if (null != aggDO.getCrisisValObsDO() && aggDO.getCrisisValObsDO().length > 0) {
				String rtn = packageData(aggDO, taskUserDO);
				 invokeObsServer(rtn);
			}
		}
		
	}

	/**
	 * 封装xml形式数据
	 * @param aggDO
	 * @param taskUserDO
	 * @return
	 * @throws BizException 
	 */
	private String packageData(CrisisvalAggDO aggDO, TaskUserDO taskUserDO) throws BizException {
		UserDO psnDocDO = ServiceFinder.find(IUserRService.class).findById(taskUserDO.getHandleperson());
		
		CrisisValDO crisisValDO = aggDO.getParentDO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		FDateTime d = new FDateTime(taskUserDO.getHandletime());
		Date dt = new Date(d.getMillis());
		//xml节点字段按照Confirminfo类构造 
		Document document = getDocumentObj();
		Element Confirminfo = document.createElement("Confirminfo");
		Element id_alert = document.createElement("id_alert");
		id_alert.setTextContent(crisisValDO.getId_alert());
		Confirminfo.appendChild(id_alert);
		
		Element code_emp_confirm = document.createElement("code_emp_confirm");
		code_emp_confirm.setTextContent(psnDocDO.getCode());
		Confirminfo.appendChild(code_emp_confirm);
		
		Element dt_confirm = document.createElement("dt_confirm");
		dt_confirm.setTextContent(format.format(dt) + "");
		Confirminfo.appendChild(dt_confirm);
		
		Element des_confirm = document.createElement("des_confirm");
		des_confirm.setTextContent(crisisValDO.getMsg_hnd());
		Confirminfo.appendChild(des_confirm);
		
		document.appendChild(Confirminfo);
		String rtn = getXmlStr(document);
		MpNrLog.apilog("\n----危急值消息确认 调用第三方接口入参【" + rtn + "】---",Level.INFO);
		return rtn;
	}

	/**
	 * 实例化Document对象，增加
	 * @return
	 * @throws BizException 
	 */
	private Document getDocumentObj() throws BizException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			document.setXmlVersion("1.0");
			return document;
		} catch (Exception e) {
			throw new BizException("实例化XML异常！");
		}
	}
	
	
	/**
	 * 生成xml字符串
	 * @param document
	 * @return
	 * @throws BizException 
	 */
	private String getXmlStr(Document document) throws BizException {
		try {
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource domSource = new DOMSource(document);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			transformer.transform(domSource, new StreamResult(bos));
			return bos.toString();
		} catch (TransformerException e) {
			throw new BizException("Xml生成失败！");
		}
	}
	
	/**
	 * 回调LIS系统第三方接口
	 * @param rtn
	 */
	public abstract void invokeLisServer(String rtn);
	
	/**
	 * 回调PACS系统第三方接口
	 * @param rtn
	 */
	public abstract void invokeObsServer(String rtn);
}
