package iih.ci.ord.s.bp.iemsg;

import iih.ci.ord.iemsg.d.IEOpBtOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiBtIpOrQry;
import iih.en.pv.out.d.EntOpVitalSignsDTO;
import iih.en.pv.out.i.IEn4CiQryService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 生成集成平台备血申请服务数据信息操作BP
 * （住院）
 * 
 */
public class GetIEIpMsgInfo4PBtBP {
	/**
	 * 生成集成平台备血申请服务数据信息
	 * （住院）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpBtOrEnDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//获得备血医嘱申请数据信息集合
		IEOpBtOrEnDTO[] rtndtos=getIEOpBtOrEnDTOs(id_ors);
		//年龄
		if (!CiOrdUtils.isEmpty(rtndtos)) {
			for (IEOpBtOrEnDTO ieOpBtOrEnDTO : rtndtos) {
				if(!CiOrdUtils.isEmpty(ieOpBtOrEnDTO.getBirthday())){
					FDateTime fd=new FDateTime(ieOpBtOrEnDTO.getBirthday().toString());
					FDate fDate=new FDate(fd.toString());
					String ager=AgeCalcUtil.getAge(fDate);
					ieOpBtOrEnDTO.setAge(ager);    
				}
				//身高体重
				String id_en=ieOpBtOrEnDTO.getId_ent();
				IEn4CiQryService service = (IEn4CiQryService)ServiceFinder.find(IEn4CiQryService.class.getName());
				try {
					if(!CiOrdUtils.isEmpty(id_en)) {
						String[] arrStrings=id_en.split(",");
						EntOpVitalSignsDTO[] dto  = service.getEntOpVitalSigns(arrStrings);
						if(!CiOrdUtils.isEmpty(dto)) {
							//体重
							if(!CiOrdUtils.isEmpty(dto[0].getWeight())) {
								ieOpBtOrEnDTO.setWeight(dto[0].getWeight().toString());
							}
							//体重单位
							if(!CiOrdUtils.isEmpty(dto[0].getName_unit_weight())) {
								ieOpBtOrEnDTO.setWeight_unit(dto[0].getName_unit_weight());
							}
							//身高
							if(!CiOrdUtils.isEmpty(dto[0].getHeight())) {
								ieOpBtOrEnDTO.setHeight(dto[0].getHeight().toString());
							}
							//身高单位
							if(!CiOrdUtils.isEmpty(dto[0].getName_unit_height())) {
								ieOpBtOrEnDTO.setHeight_unit(dto[0].getName_unit_height());
							}
						}
					}
					
				} catch (BizException e) {
					e.printStackTrace();
				}
			}
		}
		//返回备血申请医嘱数据集合信息
		return rtndtos;
	}
	
	/**
	 * 获得备血医嘱申请数据信息集合
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpBtOrEnDTO[] getIEOpBtOrEnDTOs(String id_ors) throws BizException{		
		CiBtIpOrQry qry=new CiBtIpOrQry(id_ors);
		IEOpBtOrEnDTO[] rtn = (IEOpBtOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IEOpBtOrEnDTO.class);
		 return rtn;
	}
}
