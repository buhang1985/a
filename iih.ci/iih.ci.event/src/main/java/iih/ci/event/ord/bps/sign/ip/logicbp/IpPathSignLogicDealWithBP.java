package iih.ci.event.ord.bps.sign.ip.logicbp;

import iih.ci.event.ord.bps.sign.ip.query.IpPathSignApplyInfoQuery;
import iih.ci.event.ord.bps.sign.ip.query.IpPathSignContacterInfoQuery;
import iih.ci.event.ord.bps.sign.ip.query.IpPathSignDiagInfoQuery;
import iih.ci.event.ord.bps.sign.ip.query.IpPathSignEntInfoQuery;
import iih.ci.event.ord.bps.sign.ip.query.IpPathSignOrdInfoQuery;
import iih.ci.event.ord.bps.sign.ip.query.IpPathSignSampleInfoQuery;
import iih.ci.event.ord.bps.sign.ip.query.IpPathSignSrvInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.mr.i.ICiMrOutQryServices;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.ord.iemsg.d.IEIpPathApplyDTO;
import iih.ci.ord.iemsg.d.IEIpPathContactDTO;
import iih.ci.ord.iemsg.d.IEIpPathDiagDTO;
import iih.ci.ord.iemsg.d.IEIpPathEntDTO;
import iih.ci.ord.iemsg.d.IEIpPathOrdDTO;
import iih.ci.ord.iemsg.d.IEIpPathSampleDTO;
import iih.ci.ord.iemsg.d.IEIpPathSrvDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
/**
 *  住院签署 病理处理逻辑BS452
 * @author F
 *
 * @date 2020年1月20日下午1:22:41
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.logicbp.IpPathSignLogicDealWithBP
 */
public class IpPathSignLogicDealWithBP extends CommonParamBP{

	/**
	 * 生成集成平台病理申请服务数据信息
	 * (住院)
	 * @param firedto
	 * @return
	 * @throws BizException
	 */
	public BaseDTO[] exec(OrdEventFireDTO firedto) throws BizException{
		if(OrdEventUtil.isEmpty(firedto)||OrdEventUtil.isEmpty(firedto.getIdors())) {
			return null;
		}
		//1.查询就诊信息【IEIpPathEntDTO】
		IEIpPathEntDTO[] entDTOs=getIEIpPathEntDTOs(firedto.getIdors());
		//设置值
		setValue(entDTOs);
		//1.1查询联系人【IEIpPathContactDTO】
		IEIpPathContactDTO[] contacterDTOs=getIEIpPathContactDTOs(firedto.getIdors());
		//1.2查询申请单【IEIpPathApplyDTO】
		IEIpPathApplyDTO[] applyDTOs=getIEIpPathApplyDTOs(firedto.getIdors());
		//1.2.1查询费用项目明细【IEIpPathSrvDTO】
		IEIpPathSrvDTO[] srvDTOs=getIEIpPathSrvDTOs(firedto.getIdors());
		//1.2.2查询医嘱项目【IEIpPathOrdDTO】
		IEIpPathOrdDTO[] ordDTOs=getIEIpPathOrdDTOs(firedto.getIdors());
		//设置值
		setValue(ordDTOs);
		//1.2.2.1查询标本信息【IEIpPathSampleDTO】
		IEIpPathSampleDTO[] sampleDTOs=getIEIpPathSampleDTOs(firedto.getIdors());
		//1.3查询诊断信息【IEIpPathDiagDTO】
		IEIpPathDiagDTO[] diagDTOs=getIEIpPathDiagDTOs(firedto.getIdors());
		//2.组装数据
		assemableData(entDTOs,contacterDTOs,applyDTOs,srvDTOs,ordDTOs,sampleDTOs,diagDTOs);
		return entDTOs;
	}
	/**
	 * 设置值
	 * @param entDTOs
	 * @throws BizException
	 */
	private void setValue(IEIpPathOrdDTO[] ordDTOs)throws BizException{
		if(OrdEventUtil.isEmpty(ordDTOs)) {
			return;
		}
		if(!OrdEventUtil.isEmpty(ordDTOs[0])&&!OrdEventUtil.isEmpty(ordDTOs[0].getId_en())) {
			try {
				ICiMrOutQryServices pastService = (ICiMrOutQryServices)ServiceFinder.find(ICiMrOutQryServices.class.getName());//既往史
				
				String[] arrStrings=ordDTOs[0].getId_en().split(OrdEventUtil.COMMA_STR);
				
				String[] codeStrings= {"S.04"}; 
				MrDocRefValueDO[] mrdo  = pastService.getCimrPhaseByElemCode(arrStrings[0].toString(), codeStrings);
				for(IEIpPathOrdDTO ordDTO:ordDTOs) {
					//既往史
					if(!OrdEventUtil.isEmpty(mrdo)) {
						ordDTO.setPastdiseasename(mrdo[mrdo.length-1].getContent());
					}
				}
			} catch (Exception e) {
				;
			}
		}
	}
	/**
	 * 设置值
	 * @param entDTOs
	 * @throws BizException
	 */
	private void setValue(IEIpPathEntDTO[] entDTOs)throws BizException{
		if(OrdEventUtil.isEmpty(entDTOs)) {
			return;
		}
		for(IEIpPathEntDTO entDTO:entDTOs) {
			//年龄
			if(!OrdEventUtil.isEmpty(entDTO.getBirthdate())) {
				entDTO.setAge(AgeCalcUtil.getAge(new FDate(entDTO.getBirthdate().toString())));
			}
			//就诊次数
			if(OrdEventUtil.isEmpty(entDTO.getVisittimes())) {
				entDTO.setVisittimes("0");
			}
			//就诊类别
			entDTO.setVisittypecode(getParamCodeEntp(entDTO.getVisittypecode()));
		}
	}
	/**
	 * 组装数据
	 * @param entDTOs
	 * @param contacterDTOs
	 * @param applyDTOs
	 * @param srvDTOs
	 * @param ordDTOs
	 * @param sampleDTOs
	 * @param diagDTOs
	 * @throws BizException
	 */
	private void assemableData(IEIpPathEntDTO[] entDTOs,IEIpPathContactDTO[] contacterDTOs,
			IEIpPathApplyDTO[] applyDTOs,IEIpPathSrvDTO[] srvDTOs,IEIpPathOrdDTO[] ordDTOs,IEIpPathSampleDTO[] sampleDTOs,IEIpPathDiagDTO[] diagDTOs)throws BizException{
		if(OrdEventUtil.isEmpty(entDTOs)) {//以就诊数据为主 没有直接返回
			return;
		}
		//组装医嘱信息和标本信息
		assemableData(ordDTOs, sampleDTOs);
		//组装申请单和费用、医嘱信息
		assemableData(applyDTOs, srvDTOs, ordDTOs);
		//组装就诊和联系人、申请单、诊断信息
		assemableData(entDTOs, contacterDTOs,applyDTOs,diagDTOs);
	}
	/**
	 * 组装就诊和联系人、申请单、诊断信息
	 * @param entDTOs
	 * @param contacterDTOs
	 * @param applyDTOs
	 * @param diagDTOs
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void assemableData(IEIpPathEntDTO[] entDTOs,IEIpPathContactDTO[] contacterDTOs,IEIpPathApplyDTO[] applyDTOs,IEIpPathDiagDTO[] diagDTOs)throws BizException{
		if(OrdEventUtil.isEmpty(entDTOs)) {
			return;
		}
		if(!OrdEventUtil.isEmpty(contacterDTOs)) {//联系人
			for(IEIpPathEntDTO entDTO:entDTOs) {
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEIpPathContactDTO contactDTO:contacterDTOs) {
					if(!OrdEventUtil.isEmpty(entDTO)&&!OrdEventUtil.isEmpty(contactDTO)&&!OrdEventUtil.isEmpty(entDTO.getPatientlid())&&!OrdEventUtil.isEmpty(contactDTO.getId_patient())
							&&entDTO.getPatientlid().equals(contactDTO.getId_patient())) {
						fArrayList2.add(contactDTO);
					}
				}
				entDTO.setId_contactlists(fArrayList2);
			}
		}
		if(!OrdEventUtil.isEmpty(applyDTOs)) {//申请单
			for(IEIpPathEntDTO entDTO:entDTOs) {
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEIpPathApplyDTO applyDTO:applyDTOs) {
					if(!OrdEventUtil.isEmpty(applyDTO)&&!OrdEventUtil.isEmpty(entDTO)&&!OrdEventUtil.isEmpty(applyDTO.getId_or())&&!OrdEventUtil.isEmpty(entDTO.getId_or())
							&&applyDTO.getId_or().equals(entDTO.getId_or())) {
						fArrayList2.add(applyDTO);
					}
				}
				entDTO.setId_applylists(fArrayList2);
			}
		}
		if(!OrdEventUtil.isEmpty(diagDTOs)) {//诊断
			for(IEIpPathEntDTO entDTO:entDTOs) {
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEIpPathDiagDTO diagDTO:diagDTOs) {
					if(!OrdEventUtil.isEmpty(diagDTO)&&!OrdEventUtil.isEmpty(entDTO)&&!OrdEventUtil.isEmpty(diagDTO.getId_or())&&!OrdEventUtil.isEmpty(entDTO.getId_or())
							&&diagDTO.getId_or().equals(entDTO.getId_or())) {
						fArrayList2.add(diagDTO);
					}
				}
				entDTO.setId_diaglists(fArrayList2);
			}
		}
	}
	/**
	 * 组装申请单和费用、医嘱信息
	 * @param applyDTOs
	 * @param srvDTOs
	 * @param ordDTOs
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void assemableData(IEIpPathApplyDTO[] applyDTOs,IEIpPathSrvDTO[] srvDTOs,IEIpPathOrdDTO[] ordDTOs)throws BizException{
		if(OrdEventUtil.isEmpty(applyDTOs)) {
			return;
		}
		if(!OrdEventUtil.isEmpty(srvDTOs)) {//费用
			for(IEIpPathApplyDTO applyDTO:applyDTOs) {
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEIpPathSrvDTO srvDTO:srvDTOs) {
					if(!OrdEventUtil.isEmpty(applyDTO)&&!OrdEventUtil.isEmpty(srvDTO)&&!OrdEventUtil.isEmpty(applyDTO.getId_or())&&!OrdEventUtil.isEmpty(srvDTO.getId_or())
							&&applyDTO.getId_or().equals(srvDTO.getId_or())) {
						fArrayList2.add(srvDTO);
					}
				}
				applyDTO.setId_srvlists(fArrayList2);
			}
		}
		if(!OrdEventUtil.isEmpty(ordDTOs)) {//医嘱
			for(IEIpPathApplyDTO applyDTO:applyDTOs) {
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEIpPathOrdDTO ordDTO:ordDTOs) {
					if(!OrdEventUtil.isEmpty(applyDTO)&&!OrdEventUtil.isEmpty(ordDTO)&&!OrdEventUtil.isEmpty(applyDTO.getId_or())&&!OrdEventUtil.isEmpty(ordDTO.getId_or())
							&&applyDTO.getId_or().equals(ordDTO.getId_or())) {
						fArrayList2.add(ordDTO);
					}
				}
				applyDTO.setId_orlists(fArrayList2);
			}
		}
	}
	/**
	 * 组装医嘱信息和标本信息
	 * @param ordDTOs
	 * @param sampleDTOs
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void assemableData(IEIpPathOrdDTO[] ordDTOs,IEIpPathSampleDTO[] sampleDTOs)throws BizException{
		if(OrdEventUtil.isEmpty(ordDTOs)) {
			return;
		}
		if(!OrdEventUtil.isEmpty(sampleDTOs)) {//标本
			for(IEIpPathOrdDTO ordDTO:ordDTOs) {
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEIpPathSampleDTO sampleDTO:sampleDTOs) {
					if(!OrdEventUtil.isEmpty(ordDTO)&&!OrdEventUtil.isEmpty(sampleDTO)&&!OrdEventUtil.isEmpty(ordDTO.getId_or())&&!OrdEventUtil.isEmpty(sampleDTO.getId_or())
							&&ordDTO.getId_or().equals(sampleDTO.getId_or())) {
						fArrayList2.add(sampleDTO);
					}
				}
				ordDTO.setId_samplelists(fArrayList2);
			}
		}
	}
	/**
	 * 查询就诊信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEIpPathEntDTO[] getIEIpPathEntDTOs(String id_ors)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)) {
			return null;
		}
		IpPathSignEntInfoQuery query = new IpPathSignEntInfoQuery(id_ors);
		IEIpPathEntDTO[] dtos = (IEIpPathEntDTO[])AppFwUtil.getDORstWithDao(query, IEIpPathEntDTO.class);
		return dtos;
	}
	/**
	 * 查询联系人信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEIpPathContactDTO[] getIEIpPathContactDTOs(String id_ors)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)) {
			return null;
		}
		IpPathSignContacterInfoQuery query = new IpPathSignContacterInfoQuery(id_ors);
		IEIpPathContactDTO[] dtos = (IEIpPathContactDTO[])AppFwUtil.getDORstWithDao(query, IEIpPathContactDTO.class);
		return dtos;
	}
	/**
	 * 查询申请单信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEIpPathApplyDTO[] getIEIpPathApplyDTOs(String id_ors)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)) {
			return null;
		}
		IpPathSignApplyInfoQuery query = new IpPathSignApplyInfoQuery(id_ors);
		IEIpPathApplyDTO[] dtos = (IEIpPathApplyDTO[])AppFwUtil.getDORstWithDao(query, IEIpPathApplyDTO.class);
		return dtos;
	}
	/**
	 * 查询费用项目明细信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEIpPathSrvDTO[] getIEIpPathSrvDTOs(String id_ors)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)) {
			return null;
		}
		IpPathSignSrvInfoQuery query = new IpPathSignSrvInfoQuery(id_ors);
		IEIpPathSrvDTO[] dtos = (IEIpPathSrvDTO[])AppFwUtil.getDORstWithDao(query, IEIpPathSrvDTO.class);
		return dtos;
	}
	/**
	 * 查询医嘱项目信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEIpPathOrdDTO[] getIEIpPathOrdDTOs(String id_ors)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)) {
			return null;
		}
		IpPathSignOrdInfoQuery query = new IpPathSignOrdInfoQuery(id_ors);
		IEIpPathOrdDTO[] dtos = (IEIpPathOrdDTO[])AppFwUtil.getDORstWithDao(query, IEIpPathOrdDTO.class);
		return dtos;
	}
	/**
	 * 查询医嘱项目信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEIpPathSampleDTO[] getIEIpPathSampleDTOs(String id_ors)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)) {
			return null;
		}
		IpPathSignSampleInfoQuery query = new IpPathSignSampleInfoQuery(id_ors);
		IEIpPathSampleDTO[] dtos = (IEIpPathSampleDTO[])AppFwUtil.getDORstWithDao(query, IEIpPathSampleDTO.class);
		return dtos;
	}
	/**
	 * 查询诊断信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEIpPathDiagDTO[] getIEIpPathDiagDTOs(String id_ors)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)) {
			return null;
		}
		IpPathSignDiagInfoQuery query = new IpPathSignDiagInfoQuery(id_ors);
		IEIpPathDiagDTO[] dtos = (IEIpPathDiagDTO[])AppFwUtil.getDORstWithDao(query, IEIpPathDiagDTO.class);
		return dtos;
	}
}
