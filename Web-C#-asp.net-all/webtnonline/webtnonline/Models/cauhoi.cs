//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace webtnonline.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class cauhoi
    {
        public int cauhoi_id { get; set; }
        public string cauhoi_text { get; set; }
        public string QCorrectAns { get; set; }
        public Nullable<int> monhoc_id { get; set; }
        public Nullable<int> dethi_id { get; set; }
        public Nullable<int> dokho_id { get; set; }
        public string QA { get; set; }
        public string QB { get; set; }
        public string QC { get; set; }
        public string QD { get; set; }
    
        public virtual dethi dethi { get; set; }
        public virtual mucdokho mucdokho { get; set; }
        public virtual monhoc monhoc { get; set; }
    }
}
