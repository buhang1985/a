package iih.bd.srv.s.bp.qry;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.nurmrtpl.d.NurMrConTplCaDO;
import iih.bd.srv.nurmrtpl.d.NurMrConTplDO;
import iih.bd.srv.nurmrtpl.i.INurmrtplCudService;
import iih.bd.srv.nurmrtpl.i.INurmrtplRService;
import iih.bd.srv.nurmrtpl.i.INurmrtplcaCudService;
import iih.bd.srv.nurmrtpl.i.INurmrtplcaRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class deleteNurTplCabp {

	/**
	 * 护理内容记录模板维护删除
	 * 
	 * @return
	 * @throws BizException
	 */
	public String exec(String id) throws BizException {

		if (StringUtil.isEmpty(id)) {

			throw new BizException("模板类别ID不能为空！");
		}

		INurmrtplcaCudService caService = ServiceFinder
				.find(INurmrtplcaCudService.class);
		INurmrtplcaRService carService = ServiceFinder
				.find(INurmrtplcaRService.class);

		INurmrtplCudService service = ServiceFinder
				.find(INurmrtplCudService.class);
		INurmrtplRService rService = ServiceFinder
				.find(INurmrtplRService.class);

		// 所有模板的类别ID集合
		List<String> listCAStr = new ArrayList<String>();

		NurMrConTplCaDO caDO = carService.findById(id);

		List<NurMrConTplCaDO> DeleteArray = new ArrayList<NurMrConTplCaDO>();

		DeleteArray.add(caDO);

		if (caDO != null) {
			// 删除为一级分类时，清除该分类下的所有子级
			if (StringUtil.isEmpty(caDO.getId_parent())) {

				NurMrConTplCaDO[] ParentDOS = carService.find(" a0.Id_parent='"
						+ id + "'", "", FBoolean.FALSE);

				for (NurMrConTplCaDO DO : ParentDOS) {

					DeleteArray.add(DO);

					listCAStr.add(DO.getId_mrnurcontplca());
				}
			} else {

				listCAStr.add(caDO.getId_mrnurcontplca());
			}
		}
		if (listCAStr != null && listCAStr.size() != 0) {
				
			String whereStr="";
			for(String Id_mrnurcontplca: (String[]) listCAStr.toArray(new String[listCAStr.size()])){
				
				whereStr+=(whereStr.length()==0?"":",")+"'"+Id_mrnurcontplca+"'";
			}		
			
			whereStr="a0.Id_mrnurcontplca in ("+whereStr+")";
									
			NurMrConTplDO[] ConTplDOS = rService.find(whereStr, null, FBoolean.FALSE);
			
			service.delete(ConTplDOS);
		}

		if (DeleteArray.size() > 0) {

			caService.delete((NurMrConTplCaDO[]) DeleteArray
					.toArray(new NurMrConTplCaDO[DeleteArray.size()]));
		}

		return "";
	}
}
