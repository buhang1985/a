package iih.bl.cg.bp.oep;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;

import iih.bl.cg.bp.oep.qry.GetRecipeDTOQry;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.mr.i.ICiMrOutQryServices;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.ci.ord.i.ICiOrdQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取收费处方信息集合
 * 
 * @author
 *
 */
public class GetOpCgRecipeListBP {
	/**
	 * 获取收费处方信息集合
	 * 
	 * @param entIds
	 *            门诊就诊编号集合
	 * @return
	 * @throws BizException
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public RecipeDTO[] exec(String[] entIds) throws BizException{

		if (ArrayUtil.isEmpty(entIds))
			return null;
		// 1.根据就诊编号获取出基础数据
		// （就诊编号，就诊科室，就诊科室code，就诊科室名称，医保科室code，医保科室名称，医师编码，医生名称挂号交易流水号）
		RecipeDTO[] baseRecips = (RecipeDTO[]) AppFwUtil.getDORstWithDao(new GetRecipeDTOQry(entIds), RecipeDTO.class);

		// 2.根据就诊编号获取对应诊断信息
		ICiOrdQryService ciorService = ServiceFinder.find(ICiOrdQryService.class);
		Map<String, List> zdMap = ciorService.getDiagItemMap(entIds);

		// 3.获取病例信息
		ICiMrOutQryServices cimrService = ServiceFinder.find(ICiMrOutQryServices.class);
		FMap2 blMap;
		try {
			blMap = cimrService.getOPCiMrByIdEnts(entIds);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new BizException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new BizException(e);
		}

		// 4.循环就诊处方将诊断与病例信息赋值进去
		for (RecipeDTO recipeDTO : baseRecips) {
			String strKey = recipeDTO.getId_en();
			if (zdMap.containsKey(strKey)) {
				for (Object zdobj : zdMap.get(strKey)) {
					CiDiagItemDO diaitm = (CiDiagItemDO) zdobj;
					String fgstr = (StringUtil.isEmpty(recipeDTO.getDidef_code()) ? "" : "&");

					recipeDTO.setDidef_code((recipeDTO.getDidef_code() != null ? recipeDTO.getDidef_code() : "") + fgstr + diaitm.getDidef_code());
					recipeDTO.setDidef_name((recipeDTO.getDidef_name() != null ? recipeDTO.getDidef_name() : "") + fgstr + diaitm.getDidef_name());
				}
			}
			if (blMap.containsKey(strKey)) {
				String nrstr = blMap.get(strKey).toString();
				// 替换医保特殊字符
				nrstr = nrstr.replaceAll("\n", "").replaceAll("|", "").replaceAll("'", "").replaceAll("\"", "");
				// 替换xml特殊字符
//				nrstr = nrstr.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("&", "&amp;").replaceAll("'", "&apos;").replaceAll("\"", "&quot;");

				if (nrstr.length() > 400) {
					nrstr = nrstr.substring(0, 400);
				}
				recipeDTO.setMr_content(nrstr);
			}
		}

		return baseRecips;
	}
}
