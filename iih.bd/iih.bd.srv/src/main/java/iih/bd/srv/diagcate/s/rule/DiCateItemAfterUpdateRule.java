package iih.bd.srv.diagcate.s.rule;

import java.util.LinkedList;
import java.util.List;

import iih.bd.srv.diagcate.d.DiCateItemDO;
import iih.bd.srv.diagcate.s.bp.UpdateDiagDefBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 疾病诊断分类项目更新后规则
 * @author guoyang
 *
 */
public class DiCateItemAfterUpdateRule implements ICompareRule<DiCateItemDO> {

	@Override
	public void process(DiCateItemDO[] arg0, DiCateItemDO[] arg1) throws BizException {
		int count = arg0.length;
		//id_didef的疾病诊断分类项目
		List<DiCateItemDO> diCateItemDOs = new LinkedList<>();
		for (int i = 0; i < count; i++) {
			DiCateItemDO newDiCateItemDO = arg0[i];
			DiCateItemDO oldDiCateItemDO = arg1[i];
			//更新DiCateItemDO，如果id_didef改变则执行bp
			if(newDiCateItemDO.getId_dica().equals(oldDiCateItemDO.getId_dica())
					&& !newDiCateItemDO.getId_didef().equals(oldDiCateItemDO.getId_didef())){
				diCateItemDOs.add(oldDiCateItemDO);
			}
		}
		//对被变更诊断定义数据执行bp
		UpdateDiagDefBp oldBp = new UpdateDiagDefBp(true);
		oldBp.exec(diCateItemDOs.toArray(new DiCateItemDO[]{}));
		//变更后的诊断定义执行bp
		UpdateDiagDefBp newBp = new UpdateDiagDefBp(false);
		newBp.exec(arg0);
	}
}
