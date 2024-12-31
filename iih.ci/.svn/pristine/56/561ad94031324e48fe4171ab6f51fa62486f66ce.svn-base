using System;
using xap.cli.sdk.render;
using xap.rui.control.forms.model;
using xap.rui.control.forms.view;

namespace ${projectname}
{
    /// <summary>
    /// 脚本
    /// </summary>
    public class ${classname}
    {
        private XapFormControl _xapFormCtrl;

        public ${classname}(XapFormControl xapFormControl)
        {
            this._xapFormCtrl = xapFormControl;
            InitEventHandler();            
        }
        
        /// <summary>
        /// 初始化事件处理器
        /// </summary>
        private void InitEventHandler()
        {
            this._xapFormCtrl.FormCreated -= _xapFormCtrl_FormCreated;
            this._xapFormCtrl.DataChanged -= _xapFormCtrl_DataChanged;
            this._xapFormCtrl.ModelFilled -= _xapFormCtrl_ModelFilled;
            this._xapFormCtrl.FormCreated += _xapFormCtrl_FormCreated;
            this._xapFormCtrl.DataChanged += _xapFormCtrl_DataChanged;
            this._xapFormCtrl.ModelFilled += _xapFormCtrl_ModelFilled;
            ${initeventhandler}
        }
        
        ${eventhandler}

        private void _xapFormCtrl_ModelFilled(object sender, EventArgs e)
        {
            ${modelfilled}
        }

        private void _xapFormCtrl_FormCreated(object sender, EventArgs e)
        {
            ${formcreated}
        }

        private void _xapFormCtrl_DataChanged(object sender, DataChangedEventArgs e)
        {
            dynamic data = e.Data;
            switch (e.PropName)
            {
                ${datachanged}
            }
        }

        /// <summary>
        /// 设置控件可用
        /// </summary>
        /// <param name="tabcode"></param>
        /// <param name="itemkey"></param>
        /// <param name="enable"></param>
        private void SetRenderEnable(string tabcode, string itemkey, bool enable)
        {
            UserRender userRender = this._xapFormCtrl.GetUserRender(tabcode, itemkey);
            if (userRender != null)
            {
                userRender.Enabled = enable;
            }
        }
        
        /// <summary>
        /// 设置控件可用
        /// </summary>
        /// <param name="tabcode"></param>
        /// <param name="itemkeys"></param>
        /// <param name="enable"></param>
        private void SetRenderEnable(string tabcode, string[] itemkeys, bool enable)
        {
            foreach (string key in itemkeys)
            {
                SetRenderEnable(tabcode,key,enable);
            }
        }
        
        /// <summary>
        /// 设置控件可用
        /// </summary>
        /// <param name="tabcode"></param>
        /// <param name="itemkeys"></param>
        /// <param name="visible"></param>
        private void SetRenderVisible(string tabcode, string[] itemkeys, bool visible)
        {
            foreach (string key in itemkeys)
            {
                SetRenderVisible(tabcode,key,visible);
            }
        }
        
        /// <summary>
        /// 设置控件可用
        /// </summary>
        /// <param name="tabcode"></param>
        /// <param name="itemkey"></param>
        /// <param name="visible"></param>
        private void SetRenderVisible(string tabcode, string itemkey, bool visible)
        {
            UserRender userRender = this._xapFormCtrl.GetUserRender(tabcode, itemkey);
            if (userRender != null)
            {
                userRender.Visible = visible;
            }
        }
    }
}