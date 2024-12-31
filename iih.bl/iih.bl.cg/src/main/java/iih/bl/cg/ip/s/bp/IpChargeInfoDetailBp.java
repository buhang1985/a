package iih.bl.cg.ip.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 住院记账信息获取，主要是护士冲账以及住院补退费节点，这里是一个冲账后的汇总信息
 * note：2017-10-22 这里需要重构，返回值类型有问题，留待后期迭代掉
 * @author yangyang
 *
 */
public class IpChargeInfoDetailBp {

	public BlCgIpDO[] exec(String strIdEnt) throws BizException
	{		
		//AND CGIP.EU_DIRECT=1  这里解释一下方向取正向，因为是左关联，保证正向的都存在，这样处理主要是为了解决后边合并记账明细的时候，合并项可以
		//保留正向记录的记账主键
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT CGIP.*,CIOR.NAME_OR AS DES_OR,DEP.NAME AS DEPMPNAME,MM.FG_CHARGE,CGIPRE.QUAN AS QUAN_MEND");
		sql.append(" FROM BL_CG_IP CGIP ");
		sql.append(" LEFT JOIN BL_CG_IP CGIPRE ON CGIP.ID_CGIP=CGIPRE.ID_PAR");
		sql.append(" LEFT JOIN BD_MM MM ON CGIP.ID_MM=MM.ID_MM");
		sql.append(" LEFT JOIN CI_ORDER CIOR ON CGIP.ID_OR=CIOR.ID_OR");
		sql.append(" LEFT JOIN BD_DEP DEP ON CGIP.ID_DEP_MP=DEP.ID_DEP ");
		sql.append(" LEFT JOIN BD_MEASDOC MEASDOC ON MEASDOC.ID_MEASDOC=CGIP.SRVU");
		sql.append(" WHERE CGIP.FG_ST='N' AND CGIP.EU_DIRECT=1 AND CGIP.ID_ENT='").append(strIdEnt).append("'");
		
		@SuppressWarnings("unchecked")
		List<BlCgIpDO> cgIpDoQryResultArr  =(List<BlCgIpDO>)new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlCgIpDO.class));
		if(ListUtil.isEmpty(cgIpDoQryResultArr))
			return null;
		List<BlCgIpDO> cgIpDoNewLst=new ArrayList<BlCgIpDO>();
		Map<String,BlCgIpDO> map=new HashMap<String,BlCgIpDO>();
		//这里对数据进行加工处理，退费必须要针对原退费记录进行退费,这里是合并项，不再走Sql语句合并
		for(BlCgIpDO cgIpDo:cgIpDoQryResultArr)
		{
			if(cgIpDo.getQuan_mend()!=null && cgIpDo.getQuan_mend().toDouble()>0)
			{
				if(map.containsKey(cgIpDo.getId_cgip()))
				{
					BlCgIpDO cgDo=map.get(cgIpDo.getId_cgip());
					cgDo.setQuan(cgDo.getQuan().sub(cgIpDo.getQuan_mend()));
				}
				else{
					cgIpDo.setQuan(cgIpDo.getQuan().sub(cgIpDo.getQuan_mend()));
					cgIpDo.setQuan_mend(new FDouble(0.00));
					map.put(cgIpDo.getId_cgip(), cgIpDo);
				}
				continue;
			}
			cgIpDoNewLst.add(cgIpDo);
		}
		
        //遍历HashMap的另一个方法  
        Set<Entry<String, BlCgIpDO>> sets = map.entrySet();  
        for(Entry<String, BlCgIpDO> entry : sets) {  
        	cgIpDoNewLst.add(entry.getValue());
        }  
		return cgIpDoNewLst.toArray(new BlCgIpDO[cgIpDoNewLst.size()]);
	}
}
