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
    
    public partial class teacher
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public teacher()
        {
            this.daymonhocs = new HashSet<daymonhoc>();
            this.dethis = new HashSet<dethi>();
        }
    
        public int tea_id { get; set; }
        public string tea_name { get; set; }
        public string tea_pass { get; set; }
        public string tea_SDT { get; set; }
        public string tea_diachi { get; set; }
        public string tea_email { get; set; }
        public string hoten { get; set; }
        public string tea_image { get; set; }
        public string pq_id { get; set; }
        public Nullable<int> accadmin { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<daymonhoc> daymonhocs { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<dethi> dethis { get; set; }
        public virtual accadmin accadmin1 { get; set; }
    }
}