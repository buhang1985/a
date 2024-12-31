package iih.bd.pp.service.bp;

import java.util.List;

import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetHpDiVsHisDiBp {

	/**获取医保诊断和his诊断对照信息
	 * @param strIdHpArr 医保计划ID
	 * @param strHisIdDi his诊断定义
	 * @return
	 * @throws BizException
	 */
	public HpDiVsHisDTO[] getHpDiVsHisDi(String strIdHp,String[] strHisIdDiArr) throws BizException
	{
		if(ArrayUtil.isEmpty(strHisIdDiArr))
			throw new BizException("传入的诊断主键为空！");
		String strParam=new String();
		for(String item:strHisIdDiArr)
		{
			strParam="'"+item+"',";
		}
		strParam="("+strParam.substring(0,strParam.length()-1)+")";
		
		StringBuilder strSql=new StringBuilder();
		strSql.append(" SELECT HPDIHIS.CODE AS Hpdidict_code,HPDIHIS.NAME AS Hpdidict_name,HISDIDEF.CODE AS Didef_code,");
		strSql.append(" HISDIDEF.NAME AS Didef_name");
		strSql.append(" From BD_HP_DI_VS_HIS HPDIHIS");
		strSql.append(" INNER JOIN BD_DI_DEF HISDIDEF ON HISDIDEF.ID_DIDEF=HPDIHIS.ID_DIDEF");
		strSql.append(" INNER JOIN BD_HP_DI_ORGINAL HPDIORGINAL ON HPDIORGINAL.CODE=HPDIHIS.CODE");
		strSql.append(" WHERE HPDIHIS.ID_HP=? AND HPDIHIS.ID_DIDEF in ").append(strParam);
		SqlParam sqlParam=new SqlParam();
		sqlParam.addParam(strIdHp);
        @SuppressWarnings("unchecked")
        List<HpDiVsHisDTO> list = (List<HpDiVsHisDTO>) new DAFacade().execQuery(strSql.toString(), sqlParam, new BeanListHandler(HpDiVsHisDTO.class));
        return list.toArray(new HpDiVsHisDTO[]{});
	}
}
