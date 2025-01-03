package iih.ci.mr.i;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.dom4j.DocumentException;

import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mrfp.cimrsugdto.d.CiMrSugDTO;
import iih.ci.ord.i.external.provide.meta.mr.d.CiOrdInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.bdfw.bbd.d.AdminAreaDO;

public interface ICiMrOutQryServices
{
	
	/**
	 * 根据就诊号获取现病史，如果没有数据则返回""
	 * @param idEnt
	 * @return
	 */
	public abstract String getCiMrHistoryOfPresentIllness(String idEnt)  throws BizException;
	
	/**
	 * 根据就诊号获取最后一次病程FMap，如果没有数据则返回new FMap();
	 * @param idEnt
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 getCiMrCourseOfLastDisease(String idEnt,FBoolean isFirst) throws BizException,DocumentException,IOException; 

	/**
	 * 根据就诊号获取所有门诊病历
	 * @param strIdEnts
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 getOPCiMrByIdEnts(String[] strIdEnts) throws BizException, DocumentException, IOException;
	
	/**
	 * 根据就诊号判断是否有病历
	 * @param idEnt
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean hasCiMrDoByIdEnts(String idEnt) throws BizException;
	
	/**
	 * 根据就诊号获取手术记录相关信息
	 * @param idEnt
	 * @return
	 * @throws BizException
	 * */
	public abstract List<CiMrSugDTO> getCiMrSurgery(String idEnt) throws BizException;
	
	/**
	 * 通过病历主键获取病历xml
	 * @param IdMr
	 * @return
	 * @throws BizException
	 */
	public abstract String getCimrXml(String IdMr) throws BizException;
	
	/**
	 * 通过病历主键获取病历内容
	 * @param IdMr
	 * @return
	 * @throws BizException
	 */
	public abstract String getCimrArea(String IdMr) throws BizException;
	
	/**
	 * 通过病历主键获取病历结构化段落
	 * @param IdMr
	 * @return
	 * @throws BizException
	 */
	public abstract MrDocRefValueDO[] getCimrPhase(String IdMr,String[] ElemCodes ) throws BizException;
	
	/**
	 * 通过就诊id获取病历结构化段落
	 * @param IdEnt 就诊主键
	 * @param ElemCodes 对于获取内容的过滤，如果为null即不限制
	 * @return
	 * @throws BizException
	 */
	public abstract MrDocRefValueDO[] getCimrPhaseByElemCode(String IdEnt,String[] ElemCodes ) throws BizException;
	
	/**
	 * 根据患者编码获取是否已经有效填写死亡报卡
	 * @param idEnt
	 * @return
	 */
	public abstract String getPatDeathByIdPat(String idPat)  throws BizException;

	/**
	 * 获取四级地址byid
	 * @param id_adminarea
	 * @return
	 */
	AdminAreaDO[]  getLevelFourAddressById(String id_adminarea) throws BizException;
	
	/**
	 * 获取四级地址bysd
	 * @param id_adminarea
	 * @return
	 */
	AdminAreaDO[]  getLevelFourAddressBySd(String code) throws BizException;
	
	/**
	 * 根据病历主键获取到签名信息
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public abstract String getSignMessage(String id_mr) throws BizException, ParseException;
	
	/**
	 * 根据id_ent查询门诊医嘱信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract List<CiOrdInfoDTO> getCiOrdInfoByIden(String id_ent) throws BizException;
	
}
