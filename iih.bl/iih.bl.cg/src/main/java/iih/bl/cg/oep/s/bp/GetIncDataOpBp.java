package iih.bl.cg.oep.s.bp;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.oep.s.bp.qry.IncDataInfoOpQry;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.dto.d.IncDataInfoOepDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取发票信息
 * @author yangyang
 * @date:2018-05-28
 */
public class GetIncDataOpBp {

	public IncDataInfoOepDTO[] exec(String strIdPat, String dtBegin, String dtEnd) throws BizException
	{
		IncDataInfoOepDTO[] incDataArr=(IncDataInfoOepDTO[])AppFwUtil.getDORstWithDao(new IncDataInfoOpQry(strIdPat,dtBegin,dtEnd),IncDataInfoOepDTO.class);
		if(!ArrayUtils.isEmpty(incDataArr))
		{
			for(IncDataInfoOepDTO item:incDataArr)
			{
				if(StTypeEnum.ST_OEP_REG.equals(item.getEu_sttp()))//如果是挂号结算
				{
					//如果是挂号结算
					item.setFg_reg(FBoolean.TRUE);
				}
				else{
					//如果是挂号结算
					item.setFg_reg(FBoolean.FALSE);
				}
			}
		}
		return incDataArr;
	}
}
