using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using webtnonline.Models;
namespace webtnonline.Controllers
{
    public class MenuController : Controller
    {
        webtracnghiemonlineEntities1 db = new webtracnghiemonlineEntities1();
        // GET: Menu
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult student()
        {
            if (Session["std_id"] == null)
            {
                return RedirectToAction("slogin","Home");
            }
            List<dethi> dethis = new List<dethi>();
            dethis = db.dethis.ToList();
            dethi d = new dethi();
            //Session["count"] = null;
            foreach (var item in dethis)
            {
         
                  

                    Session["count"] = db.cauhois.Count(x => x.dethi_id == item.dethi_id);
                

            }

            ViewData["dethisv"] = dethis;
            return View();
        }
    }
}