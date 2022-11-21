using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Web;
using System.Web.Mvc;

namespace webtnonline.Controllers
{
    public class SendemailController : Controller
    {
        // GET: Sendemail
        public ActionResult Index()
        {
            return View();
        }
        [HttpPost]
        public ActionResult Index(webtnonline.Models.gmail model,HttpPostedFileBase file)
        {
            model.To = "dungtin2727@gmail.com";
            MailMessage mm = new MailMessage(model.From, model.To);
            mm.Subject = model.Subject;
            mm.Body = model.body;
            mm.IsBodyHtml = false;
            if(file != null)
            {
                string filename = Path.GetFileName(file.FileName);
                mm.Attachments.Add(new Attachment(file.InputStream, filename));

            }
            SmtpClient smtp = new SmtpClient();
            smtp.Host = "smtp.gmail.com";
            smtp.Port = 587;
            smtp.EnableSsl = true;
            NetworkCredential nc = new NetworkCredential("ndung983@gmail.com", "gnezzvtsarhtukhr");
            smtp.UseDefaultCredentials = true;
            smtp.Credentials = nc;
            smtp.Send(mm);
            ViewBag.Message = "Gửi thành công";
            return View();
        }
    }
}