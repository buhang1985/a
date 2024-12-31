package iih.en.pv.s.bp.ip.qry;

import iih.bd.res.bed.d.Bdbed;
import iih.sc.apt.dto.d.BedQrySchmDTO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 通过床位id查询床位费用
 * @author fanlq
 *
 */
public class GetPricByBedIdBP {
	/***
	 * 通过床位id查询床位费用
	 * @param bedId
	 * @return
	 * @throws BizException
	 */
	public BedQrySchmDTO exec(String bedId) throws BizException{
		 StringBuilder strb = new StringBuilder();		
         strb.append(" select bed.id_dep_belong as id_nur, bed.id_dep_belong as id_dep, bed.id_bedsu as id_status, ");
         strb.append(" bed.sd_bedsu as sd_status, bed.id_bltpl, ");
         strb.append(" pritpl.id_bltpl, pritpl.Name_bltpl, pritpl.price from bd_bed bed ");
         strb.append(" left join (");
		 strb.append("select bltpl.id_bltpl, bltpl.name as Name_bltpl,");
		 strb.append("sum(bltplitm.quan_medu * nvl(vprice.price_std,0)) price ");
         strb.append("from bd_bltpl bltpl ");
		 strb.append("inner join bd_bltpl_itm bltplitm on bltpl.id_bltpl = bltplitm.id_bltpl ");
		 strb.append("left join (select distinct id_srv,price_std from view_price_rp) vprice on bltplitm.id_srv = vprice.id_srv ");
         strb.append("group by bltpl.id_bltpl,bltpl.name ) pritpl ");
		 strb.append("on bed.id_bltpl = pritpl.id_bltpl ");
		 strb.append("where bed.id_bed = ? ");
		 // 集团管控
		 strb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new Bdbed(), "bed"));
		 SqlParam param = new SqlParam();
         param.addParam(bedId);
         @SuppressWarnings({ "unchecked", "rawtypes" })
		 List<BedQrySchmDTO> list = (List<BedQrySchmDTO>) new DAFacade().execQuery(strb.toString(), param, new BeanListHandler(BedQrySchmDTO.class));
		 if(list != null && list.size() == 1){
			 BedQrySchmDTO[] bedQrySchmDTOs = list.toArray(new BedQrySchmDTO[0]);
			 if(bedQrySchmDTOs != null){
					return bedQrySchmDTOs[0];
			 }
		 }
         return null;
	}
}
