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
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    
    public partial class webtracnghiemonlineEntities1 : DbContext
    {
        public webtracnghiemonlineEntities1()
            : base("name=webtracnghiemonlineEntities1")
        {
        }
    
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            throw new UnintentionalCodeFirstException();
        }
    
        public virtual DbSet<accadmin> accadmins { get; set; }
        public virtual DbSet<cauhoi> cauhois { get; set; }
        public virtual DbSet<daymonhoc> daymonhocs { get; set; }
        public virtual DbSet<dethi> dethis { get; set; }
        public virtual DbSet<ketqua> ketquas { get; set; }
        public virtual DbSet<khoa> khoas { get; set; }
        public virtual DbSet<lop> lops { get; set; }
        public virtual DbSet<monhoc> monhocs { get; set; }
        public virtual DbSet<mucdokho> mucdokhoes { get; set; }
        public virtual DbSet<student> students { get; set; }
        public virtual DbSet<sysdiagram> sysdiagrams { get; set; }
        public virtual DbSet<teacher> teachers { get; set; }
    }
}
