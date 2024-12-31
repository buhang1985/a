package iih.en.que.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pub.listener.IEnOpQue4DisplayListener;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.en.que.s.event.bp.EnBrdSendInfoBP;
import iih.en.que.s.event.bp.WaferSendInfoBP;

import java.util.List;

import xap.mw.core.annotation.Reference;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

import com.wafersystems.ph.yf.webservice.IWaferServicePortType;

/**
 * 门诊队列集成平台监听器
 * @author liubin
 *
 */
@Service(serviceInterfaces={IEnOpQue4DisplayListener.class}, binding=Binding.JSONRPC)
public class EnOpQue4DisplayListener  implements IEnOpQue4DisplayListener {
	@Reference(binding = Binding.WS)
	IWaferServicePortType waferService;
	
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		EnLogUtil.getInstance().displayInfo("接收事件: " + event.getEventType()); 
		//1、验证事件，是否匹配
		this.validate(event);

		//2、包装显示所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		OpQue4EsDTO eventSourceDTO = (OpQue4EsDTO)bizUserObj.getUserObj();
		//3.发送上屏消息
		this.sendWfInfo(eventSourceDTO, event.getEventType());	
	}
	/**
	 * 发送上屏消息
	 * 
	 * @param opQue4EsDTO
	 * @param eventType
	 * @throws BizException
	 */
	@Override
	public void sendWfInfo(OpQue4EsDTO opQue4EsDTO, String eventType)
			throws BizException {
		//获取分诊使用叫号大屏类型，0-iih本系统大屏；1-威发大屏
		int brdTp = EnParamUtils.getEnBrdTp();
		if(brdTp == 0){
			EnBrdSendInfoBP enBrdBP = new EnBrdSendInfoBP();
			enBrdBP.sendBrdInfo(opQue4EsDTO, eventType);
		}
		if(brdTp == 1){
			WaferSendInfoBP waferBP = new WaferSendInfoBP();
			waferBP.sendWfInfo(opQue4EsDTO, eventType);
		}
	}
	
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException{
		if(!IEnEventConst.EVENT_SOURCE_EN_OP_QUE.equalsIgnoreCase(event.getSourceID())){
			throw new BizException(IEnMsgConst.ERROR_OPREG4IP_LISTENER_NOT_MATCH_EVENT);
		}		
	}
		
	/**
	 * 设置就诊信息
	 * 
	 * @param queId
	 * @return
	 * @throws BizException 
	 */
	private OpQue4EsDTO setEntInfo(OpQue4EsDTO es) throws BizException{
		if(es == null)
			es = new OpQue4EsDTO();
		EnLogUtil logUtil =EnLogUtil.getInstance() ;
		if(!EnValidator.isEmpty(es.getId_ent())){
			StringBuilder sb  = new StringBuilder();
			sb.append("SELECT EN.ID_ENT,");
			sb.append("EN.ID_EMP_PHY AS ID_DOC,");
			sb.append("EN.ID_PAT,");
			sb.append("EN.NAME_PAT,");
			sb.append("EN.ID_DEP_PHY,");
			sb.append("EN.DT_BIRTH_PAT,");
			sb.append("OP.ID_SCSRV,");
			sb.append("OP.TICKETNO AS TICKNO,");
			sb.append("EMP.CODE AS CODE_DOC,");
			sb.append("EMP.NAME AS NAME_DOC,");
			sb.append("DEP.CODE AS CODE_DEP,");
			sb.append("DEP.NAME AS NAME_DEP, ");
			sb.append("SCSRV.CODE AS CODE_SCSRV,");
			sb.append("SCSRV.NAME AS NAME_SRV ");
			sb.append("FROM EN_ENT EN ");
			sb.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
			sb.append("LEFT JOIN BD_PSNDOC EMP ON EN.ID_EMP_PHY = EMP.ID_PSNDOC ");
			sb.append("LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
			sb.append("LEFT JOIN SC_SRV SCSRV ON OP.ID_SCSRV = SCSRV.ID_SCSRV ");
			sb.append("WHERE EN.ID_ENT = ? ");
		    String sql = sb.toString();
		    SqlParam param = new SqlParam();
		    param.addParam(es.getId_ent());
		    List<OpQue4EsDTO> list = (List<OpQue4EsDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(OpQue4EsDTO.class)); 
			if (!EnValidator.isEmpty(list)) {
				OpQue4EsDTO e = list.get(0);
				es.setId_ent(es.getId_ent());
				es.setId_doc(e.getId_doc());
				es.setCode_doc(e.getCode_doc());
				es.setName_doc(e.getName_doc());
				es.setId_pat(e.getId_pat());
				es.setName_pat(e.getName_pat());
				es.setId_dep(e.getId_dep());
				es.setCode_dep(e.getCode_dep());
				es.setName_dep(e.getName_dep());
				es.setId_scsrv(e.getId_scsrv());
				es.setCode_scsrv(e.getCode_scsrv());
				es.setName_srv(e.getName_srv());
				es.setTickno(e.getTickno());
				es.setDt_birth_pat(e.getDt_birth_pat());
				//es.setAge(AgeCalcUtil.getAge(e.getDt_birth_pat()));
				EnAgeCalcUtil.setDoAges(new OpQue4EsDTO[]{es}, "Id_ent", "Age");
			}
		}else {
			logUtil.logInfo("Id_ent为空！");
		}
		return es;
	}
	
}
