package iih.dg.herbaldelivery.bp;

import java.util.ArrayList;
import java.util.List;

import iih.dg.herbaldelivery.dto.HerbDelvyDTO;
import iih.dg.herbaldelivery.qry.GetHerbDelvyQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @Description:草药配送单报表获取数据
 * @author zheng.yx@founder.com.cn
 * @version：2019年3月21日 下午10:30:05 创建
 */
public class GetHerbDelvyBp {

	/**
	 * 主入口
	 * 
	 * @param id_pres
	 * @return
	 * @throws BizException
	 */
	public List<HerbDelvyDTO> exec(String id_pres) throws BizException {

		// 1.校验
		validation(id_pres);

		// 2.查询数据
		HerbDelvyDTO[] herbDelvyDTOs = queryData(id_pres);

		// 3.处理数据并返回
		return getHerbDelvyData(herbDelvyDTOs);

	}

	/**
	 * 校验
	 * 
	 * @param id_pres
	 * @throws BizException
	 */
	private void validation(String id_pres) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_pres))
			throw new BizException("草药配送单:处方ID不能为空！");
	}

	/**
	 * 查询数据
	 * 
	 * @param id_pres
	 * @return
	 * @throws BizException
	 */
	private HerbDelvyDTO[] queryData(String id_pres) throws BizException {
		GetHerbDelvyQry sql = new GetHerbDelvyQry(id_pres);
		HerbDelvyDTO[] datas = (HerbDelvyDTO[]) AppFwUtil.getDORstWithDao(sql, HerbDelvyDTO.class);
		return datas;
	}

	/**
	 * 处理数据并返回
	 * 
	 * @param herbDelvyDTOs
	 * @return
	 */
	private List<HerbDelvyDTO> getHerbDelvyData(HerbDelvyDTO[] herbDelvyDTOs) {
		StringBuffer str = new StringBuffer();
		int index = 1;
		for (int i = 0; i < herbDelvyDTOs.length; i++) {
			str.append(herbDelvyDTOs[i].getName_drug());
			str.append(" ");
			str.append(herbDelvyDTOs[i].getQuan());
			str.append(herbDelvyDTOs[i].getPkug());
			if (i != herbDelvyDTOs.length - 1)
				str.append("；");
			if (index != 0 && index % 5 == 0)
				str.append("\r\n");
			index++;
		}
		HerbDelvyDTO herbDelvyDTO = herbDelvyDTOs[0];
		herbDelvyDTO.setRecipe(str.toString());
		List<HerbDelvyDTO> list = new ArrayList<HerbDelvyDTO>();
		list.add(herbDelvyDTO);
		return list;
	}
}
