package iih.ci.event.ord.bps.sign.op.logicbp;

import iih.ci.event.ord.bps.sign.op.query.OpPathSignApplyInfoQuery;
import iih.ci.event.ord.bps.sign.op.query.OpPathSignContacterInfoQuery;
import iih.ci.event.ord.bps.sign.op.query.OpPathSignDiagInfoQuery;
import iih.ci.event.ord.bps.sign.op.query.OpPathSignEntInfoQuery;
import iih.ci.event.ord.bps.sign.op.query.OpPathSignOrdInfoQuery;
import iih.ci.event.ord.bps.sign.op.query.OpPathSignSampleInfoQuery;
import iih.ci.event.ord.bps.sign.op.query.OpPathSignSrvInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.mr.i.ICiMrOutQryServices;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.ord.iemsg.d.IEOpPathApplyDTO;
import iih.ci.ord.iemsg.d.IEOpPathContactDTO;
import iih.ci.ord.iemsg.d.IEOpPathDiagDTO;
import iih.ci.ord.iemsg.d.IEOpPathEntDTO;
import iih.ci.ord.iemsg.d.IEOpPathOrdDTO;
import iih.ci.ord.iemsg.d.IEOpPathSampleDTO;
import iih.ci.ord.iemsg.d.IEOpPathSrvDTO;
import iih.en.pv.out.d.EntOpVitalSignsDTO;
import iih.en.pv.out.i.IEn4CiQryService;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
/**
 * 门诊签署 病理处理逻辑BS452
 * @author F
 *
 * @date 2020年1月16日下午6:40:24
 *
 * @classpath iih.ci.event.ord.bps.sign.op.logicbp.OpPathSignLogicDealWithBP
 */
public class OpPathSignLogicDealWithBP extends CommonParamBP{

	/**
	 * 生成集成平台病理申请服务数据信息
	 * (门诊)
	 * @param firedto
	 * @return
	 * @throws BizException
	 */
	public BaseDTO[] exec(OrdEventFireDTO firedto) throws BizException{
		if(OrdEventUtil.isEmpty(firedto)||OrdEventUtil.isEmpty(firedto.getIdors())) {
			return null;
		}
		//1.查询就诊信息【IEOpPathEntDTO】
		IEOpPathEntDTO[] entDTOs=getIEOpPathEntDTOs(firedto.getIdors());
		//设置值
		setValue(entDTOs);
		//1.1查询联系人【IEOpPathContactDTO】
		IEOpPathContactDTO[] contacterDTOs=getIEOpPathContactDTOs(firedto.getIdors());
		//1.2查询申请单【IEOpPathApplyDTO】
		IEOpPathApplyDTO[] applyDTOs=getIEOpPathApplyDTOs(firedto.getIdors());
		//1.2.1查询费用项目明细【IEOpPathSrvDTO】
		IEOpPathSrvDTO[] srvDTOs=getIEOpPathSrvDTOs(firedto.getIdors());
		//1.2.2查询医嘱项目【IEOpPathOrdDTO】
		IEOpPathOrdDTO[] ordDTOs=getIEOpPathOrdDTOs(firedto.getIdors());
		//设置值
		setValue(ordDTOs);
		//1.2.2.1查询标本信息【IEOpPathSampleDTO】
		IEOpPathSampleDTO[] sampleDTOs=getIEOpPathSampleDTOs(firedto.getIdors());
		//1.3查询诊断信息【IEOpPathDiagDTO】
		IEOpPathDiagDTO[] diagDTOs=getIEOpPathDiagDTOs(firedto.getIdors());
		//2.组装数据
		assemableData(entDTOs,contacterDTOs,applyDTOs,srvDTOs,ordDTOs,sampleDTOs,diagDTOs);
		return entDTOs;
	}
	/**
	 * 设置值
	 * @param entDTOs
	 * @throws BizException
	 */
	private void setValue(IEOpPathOrdDTO[] ordDTOs)throws BizException{
		if(OrdEventUtil.isEmpty(ordDTOs)) {
			return;
		}
		if(!OrdEventUtil.isEmpty(ordDTOs[0])&&!OrdEventUtil.isEmpty(ordDTOs[0].getId_en())) {
			try {
				IEn4CiQryService service = (IEn4CiQryService)ServiceFinder.find(IEn4CiQryService.class.getName());//身高体重
				ICiMrOutQryServices pastService = (ICiMrOutQryServices)ServiceFinder.find(ICiMrOutQryServices.class.getName());//既往史
				
				String[] arrStrings=ordDTOs[0].getId_en().split(OrdEventUtil.COMMA_STR);
				EntOpVitalSignsDTO[] dto  = service.getEntOpVitalSigns(arrStrings);
				
				String[] codeStrings= {"S.04"}; 
				MrDocRefValueDO[] mrdo  = pastService.getCimrPhaseByElemCode(arrStrings[0].toString(), codeStrings);
				
				if(!OrdEventUtil.isEmpty(dto)) {
					for(IEOpPathOrdDTO ordDTO:ordDTOs) {
						//体重
						if(!OrdEventUtil.isEmpty(dto[0].getWeight())) {
							ordDTO.setWeight(dto[0].getWeight().toString());
						}
						//体重单位
						if(!OrdEventUtil.isEmpty(dto[0].getName_unit_weight())) {
							ordDTO.setWeightunit(dto[0].getName_unit_weight());
						}
						//身高
						if(!OrdEventUtil.isEmpty(dto[0].getHeight())) {
							ordDTO.setHeight(dto[0].getHeight().toString());
						}
						//身高单位
						if(!OrdEventUtil.isEmpty(dto[0].getName_unit_height())) {
							ordDTO.setHeightunit(dto[0].getName_unit_height());
						}
						//既往史
						if(!OrdEventUtil.isEmpty(mrdo)) {
							ordDTO.setPastdiseasename(mrdo[mrdo.length-1].getContent());
						}
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
	private void setValue(IEOpPathEntDTO[] entDTOs)throws BizException{
		if(OrdEventUtil.isEmpty(entDTOs)) {
			return;
		}
		for(IEOpPathEntDTO entDTO:entDTOs) {
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
	private void assemableData(IEOpPathEntDTO[] entDTOs,IEOpPathContactDTO[] contacterDTOs,
			IEOpPathApplyDTO[] applyDTOs,IEOpPathSrvDTO[] srvDTOs,IEOpPathOrdDTO[] ordDTOs,IEOpPathSampleDTO[] sampleDTOs,IEOpPathDiagDTO[] diagDTOs)throws BizException{
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
	private void assemableData(IEOpPathEntDTO[] entDTOs,IEOpPathContactDTO[] contacterDTOs,IEOpPathApplyDTO[] applyDTOs,IEOpPathDiagDTO[] diagDTOs)throws BizException{
		if(OrdEventUtil.isEmpty(entDTOs)) {
			return;
		}
		if(!OrdEventUtil.isEmpty(contacterDTOs)) {//联系人
			for(IEOpPathEntDTO entDTO:entDTOs) {
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEOpPathContactDTO contactDTO:contacterDTOs) {
					if(!OrdEventUtil.isEmpty(entDTO)&&!OrdEventUtil.isEmpty(contactDTO)&&!OrdEventUtil.isEmpty(entDTO.getPatientlid())&&!OrdEventUtil.isEmpty(contactDTO.getId_patient())
							&&entDTO.getPatientlid().equals(contactDTO.getId_patient())) {
						fArrayList2.add(contactDTO);
					}
				}
				entDTO.setId_contactlists(fArrayList2);
			}
		}
		if(!OrdEventUtil.isEmpty(applyDTOs)) {//申请单
			for(IEOpPathEntDTO entDTO:entDTOs) {
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEOpPathApplyDTO applyDTO:applyDTOs) {
					if(!OrdEventUtil.isEmpty(applyDTO)&&!OrdEventUtil.isEmpty(entDTO)&&!OrdEventUtil.isEmpty(applyDTO.getId_or())&&!OrdEventUtil.isEmpty(entDTO.getId_or())
							&&applyDTO.getId_or().equals(entDTO.getId_or())) {
						fArrayList2.add(applyDTO);
					}
				}
				entDTO.setId_applylists(fArrayList2);
			}
		}
		if(!OrdEventUtil.isEmpty(diagDTOs)) {//诊断
			for(IEOpPathEntDTO entDTO:entDTOs) {
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEOpPathDiagDTO diagDTO:diagDTOs) {
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
	private void assemableData(IEOpPathApplyDTO[] applyDTOs,IEOpPathSrvDTO[] srvDTOs,IEOpPathOrdDTO[] ordDTOs)throws BizException{
		if(OrdEventUtil.isEmpty(applyDTOs)) {
			return;
		}
		if(!OrdEventUtil.isEmpty(srvDTOs)) {//费用
			for(IEOpPathApplyDTO applyDTO:applyDTOs) {
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEOpPathSrvDTO srvDTO:srvDTOs) {
					if(!OrdEventUtil.isEmpty(applyDTO)&&!OrdEventUtil.isEmpty(srvDTO)&&!OrdEventUtil.isEmpty(applyDTO.getId_or())&&!OrdEventUtil.isEmpty(srvDTO.getId_or())
							&&applyDTO.getId_or().equals(srvDTO.getId_or())) {
						fArrayList2.add(srvDTO);
					}
				}
				applyDTO.setId_srvlists(fArrayList2);
			}
		}
		if(!OrdEventUtil.isEmpty(ordDTOs)) {//医嘱
			for(IEOpPathApplyDTO applyDTO:applyDTOs) {
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEOpPathOrdDTO ordDTO:ordDTOs) {
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
	private void assemableData(IEOpPathOrdDTO[] ordDTOs,IEOpPathSampleDTO[] sampleDTOs)throws BizException{
		if(OrdEventUtil.isEmpty(ordDTOs)) {
			return;
		}
		if(!OrdEventUtil.isEmpty(sampleDTOs)) {//标本
			for(IEOpPathOrdDTO ordDTO:ordDTOs) {
				FArrayList2 fArrayList2=new FArrayList2();
				for(IEOpPathSampleDTO sampleDTO:sampleDTOs) {
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
	private IEOpPathEntDTO[] getIEOpPathEntDTOs(String id_ors)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)) {
			return null;
		}
		OpPathSignEntInfoQuery query = new OpPathSignEntInfoQuery(id_ors);
		IEOpPathEntDTO[] dtos = (IEOpPathEntDTO[])AppFwUtil.getDORstWithDao(query, IEOpPathEntDTO.class);
		return dtos;
	}
	/**
	 * 查询联系人信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpPathContactDTO[] getIEOpPathContactDTOs(String id_ors)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)) {
			return null;
		}
		OpPathSignContacterInfoQuery query = new OpPathSignContacterInfoQuery(id_ors);
		IEOpPathContactDTO[] dtos = (IEOpPathContactDTO[])AppFwUtil.getDORstWithDao(query, IEOpPathContactDTO.class);
		return dtos;
	}
	/**
	 * 查询申请单信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpPathApplyDTO[] getIEOpPathApplyDTOs(String id_ors)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)) {
			return null;
		}
		OpPathSignApplyInfoQuery query = new OpPathSignApplyInfoQuery(id_ors);
		IEOpPathApplyDTO[] dtos = (IEOpPathApplyDTO[])AppFwUtil.getDORstWithDao(query, IEOpPathApplyDTO.class);
		return dtos;
	}
	/**
	 * 查询费用项目明细信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpPathSrvDTO[] getIEOpPathSrvDTOs(String id_ors)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)) {
			return null;
		}
		OpPathSignSrvInfoQuery query = new OpPathSignSrvInfoQuery(id_ors);
		IEOpPathSrvDTO[] dtos = (IEOpPathSrvDTO[])AppFwUtil.getDORstWithDao(query, IEOpPathSrvDTO.class);
		return dtos;
	}
	/**
	 * 查询医嘱项目信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpPathOrdDTO[] getIEOpPathOrdDTOs(String id_ors)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)) {
			return null;
		}
		OpPathSignOrdInfoQuery query = new OpPathSignOrdInfoQuery(id_ors);
		IEOpPathOrdDTO[] dtos = (IEOpPathOrdDTO[])AppFwUtil.getDORstWithDao(query, IEOpPathOrdDTO.class);
		return dtos;
	}
	/**
	 * 查询医嘱项目信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpPathSampleDTO[] getIEOpPathSampleDTOs(String id_ors)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)) {
			return null;
		}
		OpPathSignSampleInfoQuery query = new OpPathSignSampleInfoQuery(id_ors);
		IEOpPathSampleDTO[] dtos = (IEOpPathSampleDTO[])AppFwUtil.getDORstWithDao(query, IEOpPathSampleDTO.class);
		return dtos;
	}
	/**
	 * 查询诊断信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpPathDiagDTO[] getIEOpPathDiagDTOs(String id_ors)throws BizException{
		if(OrdEventUtil.isEmpty(id_ors)) {
			return null;
		}
		OpPathSignDiagInfoQuery query = new OpPathSignDiagInfoQuery(id_ors);
		IEOpPathDiagDTO[] dtos = (IEOpPathDiagDTO[])AppFwUtil.getDORstWithDao(query, IEOpPathDiagDTO.class);
		return dtos;
	}
}
