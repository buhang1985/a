package iih.nm.nqm.nmnqmtask.refs;

import iih.nm.nqm.nmnqmtask.d.NqmTaskDetDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 任务明细参照
 * @author 王鹏 
 * @date 2019/03/08
 */
public class NmNqmTaskDetRefModel extends RefGridModel{

    @Override
    public String[] getShowFieldCode() {
        return new String[] { NqmTaskDetDO.NAME };
    }

    @Override
    public String[] getShowFieldName() {
        return new String[] { "任务明细名称" };
    }

    @Override
    public String[] getHiddenFieldCode() {
        return new String[] { NqmTaskDetDO.ID_NQM_TASK_DET };
    }

    @Override
    public String getPkFieldCode() {
        return NqmTaskDetDO.ID_NQM_TASK_DET;
    }

    @Override
    public String getRefNameField() {
        return NqmTaskDetDO.NAME;
    }

    @Override
    public String getTableName() {
        return new NqmTaskDetDO().getTableName();
    }

    @Override
    public String[] getBlurFields() {
        return super.getBlurFields();
    }
}
