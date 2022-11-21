using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using webtnonline.Models;

namespace webtnonline.Controllers
{
    public class HomeController : Controller
    {
        webtracnghiemonlineEntities1 db = new webtracnghiemonlineEntities1();
        public ActionResult Index()
        {
            if (Session["tea"] != null)
            {
                return RedirectToAction("Dashbroad");
            }
            return View();
        }
        public ActionResult Dashbroad()
        {
            return View();
        }
        [HttpGet]
        public ActionResult cauhoi()
        {
            int sid = Convert.ToInt32(Session["adminid"]);
            List<dethi> li = db.dethis.Where(x => x.tea_id == sid).ToList();
            List<monhoc> ti = db.monhocs.OrderByDescending(x=>x.monhoc_id).ToList();
            List<mucdokho> dokho = db.mucdokhoes.OrderByDescending(x=>x.id_dokho).ToList();
            ViewData["dethi"] = new SelectList(li, "dethi_id", "dethi_name");
            ViewData["monhoc"] = new SelectList(ti, "monhoc_id", "tenmonhoc");
            ViewData["mucdokho"] = new SelectList(dokho, "id_dokho", "tendokho");
            return View();
        }
        [HttpPost]
        public ActionResult cauhoi(cauhoi q)
        {
            int sid = Convert.ToInt32(Session["adminid"]);
            List<dethi> li = db.dethis.Where(x => x.tea_id == sid).ToList();
            ViewBag.list = new SelectList(li, "car_id", "cat_name");
            cauhoi qa = new cauhoi();
            qa.cauhoi_text = q.cauhoi_text;
            qa.QA = q.QA;
            qa.QB = q.QB;
            qa.QC = q.QC;
            qa.QD = q.QD;
            qa.QCorrectAns = q.QCorrectAns;
            qa.dethi_id = q.dethi_id;
            qa.dokho_id = q.dokho_id;
            qa.monhoc_id = q.monhoc_id;
            db.cauhois.Add(qa);
            db.SaveChanges();
            TempData["ms"] = "question add success";
            TempData.Keep();
            return RedirectToAction("cauhoi");
            return View();
        }

        [HttpGet]
        public ActionResult dethi()
        {
            if (Session["tea"] == null)
            {
                return RedirectToAction("Dashbroad");
            }
            else if(Session["ad"] != null)
            {
                List<dethi> d = db.dethis.ToList();
                return View(d);
            }
           
           
           
            //Session["adminid"] = 1;
            int ad_id = Convert.ToInt32(Session["tea"].ToString());
            List<dethi> categoryList = db.dethis.Where(x => x.tea_id == ad_id).OrderByDescending(x => x.dethi_id).ToList();
            List<teacher> li = db.teachers.Where(x => x.tea_id == ad_id).ToList();

            ViewData["tea"] = new SelectList(li, "tea_id", "tea_name");
            ViewData["list"] = categoryList;
            return View();
        }
        [HttpPost]
        public ActionResult dethi(dethi cat)
        {

            List<dethi> categoryList = db.dethis.OrderByDescending(x => x.dethi_id).ToList();
            ViewData["list"] = categoryList;
            dethi cate = new dethi();

            Random r = new Random();

            cate.dethi_name = cat.dethi_name;
            cate.tea_id = cat.tea_id;
            cate.phongthi_id = crypt.Encrypt(cat.dethi_name.Trim() + r.Next().ToString(), true);
            db.dethis.Add(cate);
            db.SaveChanges();
            return RedirectToAction("dethi");
        }
        public ActionResult sinhvien()
        {
            return View();
        }
        
        //public ActionResult giaovien()
        //{
            
        //    List<teacher> li = db.teachers.OrderByDescending(x=>x.tea_id).ToList();

        //    ViewData["tea_list"] = li;
            
        //    return View();
        //}
        //[HttpPost]
        //public ActionResult giaovien(teacher t)
        //{
        //    teacher tea = new teacher();
        //    tea.tea_name = t.tea_name;
        //    tea.tea_pass = t.tea_pass;
        //    tea.tea_SDT = t.tea_SDT;
        //    tea.tea_email = t.tea_email;
        //    tea.tea_diachi = t.tea_diachi;
        //    db.teachers.Add(tea);
        //    db.SaveChanges();
        //    return RedirectToAction("giaovien");
        //}
        public ActionResult khoa()
        {
            return View();
        }
        public ActionResult lop()
        {
            return View();
        }
        public ActionResult monhoc()
        {
            return View();
        }
        public ActionResult mucdokho()
        {
            return View();
        }
        public ActionResult slogin()
        {
            return View();
        }
        [HttpPost]
        public ActionResult slogin(student st)
        {
            student std = db.students.Where(x => x.std_name == st.std_name && x.std_password == st.std_password).SingleOrDefault();
            teacher giaovien = db.teachers.Where(x => x.tea_name == st.std_name && x.tea_pass == st.std_password).SingleOrDefault();
            accadmin admin = db.accadmins.Where(x => x.username == st.std_name && x.passwordd == st.std_password).SingleOrDefault();
                if (giaovien != null)
                {
                if (giaovien.pq_id != null)
                {
                    Session["tea"] = giaovien.tea_id;
                    teacher t = db.teachers.Where(x => x.tea_id == giaovien.tea_id).SingleOrDefault();
                    Session["tea_name"] ="giáo viên "+ t.hoten;
                    return RedirectToAction("Dashbroad");
                }
                }
            
            if (admin != null)
            {
              
                    Session["ad"] = admin.pq;
                    Session["ad-main"] = admin.username;
                return RedirectToAction("Dashbroad");
            }

            if (std != null)
                {
                Session["std_id"] = std.std_id;
                student s = new student();
                s = db.students.Where(x => x.std_id == std.std_id).SingleOrDefault();
                Session["namestudent"] = s.hoten;
                //return RedirectToAction("examDashbroad");
                return RedirectToAction("student","Menu");
             
                }
                else if (admin==null && std==null && giaovien==null)
                {
                ViewBag.msg = "invaild username and password fail";
            }
          

            return View();



        }
     
        public ActionResult examDashbroad()
        {
            //if (Session["std_id"] == null)
            //{
            //    return RedirectToAction("slogin");
            //}
            //List<dethi> dethis = new List<dethi>();
            //dethis = db.dethis.ToList();
            //dethi d = new dethi();
            //foreach(var item in dethis)
            //{
            //    if(d.dethi_id == item.dethi_id)
            //    {

            //    }

            //}
            
            //ViewData["dethisv"]=dethis;
            return View();
        }
        [HttpPost]
        public ActionResult examDashbroad(string room)
        {
            List<dethi> list = db.dethis.ToList();
            foreach (var item in list)
            {
                if (item.phongthi_id == room)
                {
                    List<cauhoi> li = db.cauhois.Where(x => x.dethi_id == item.dethi_id).ToList();
                    //cauhoi c=db.cauhois.Where(x=>x.dethi_id==item.dethi_id).to
                    Session["cauhoi"]=li;
                    //Queue<cauhoi> queue = new Queue<cauhoi>();
                    //foreach (cauhoi a in li)
                    //{
                    //    queue.Enqueue(a);
                    //}
                    TempData["phongthi"] = room;
                    TempData["examid"] = item.dethi_id;
                    //TempData["quest"] = li.ToList();
                    //TempData["quest"] = queue;
                    TempData["score"] = 0;
                    TempData["dem"] = 0;
                    TempData["caudung"] = 0;
                    TempData.Keep();
                    return RedirectToAction("startquiz");
                }
                else
                {
                    ViewBag.error = "no found room";
                }
            }
            return View();
        }
        public ActionResult startquiz()
        {
            int ID = Convert.ToInt32(TempData["examid"]);
            List<cauhoi> cauhoi = db.cauhois.Where(x => x.dethi_id==ID).ToList();
            dethi d = db.dethis.Where(x => x.dethi_id == ID).SingleOrDefault();
            int c = db.cauhois.Count(x => x.dethi_id == ID);
            Session["soluong"] = c;
            Session["tendethi"]=d.dethi_name;
            Session["made"]=d.dethi_id;
            return View(cauhoi);
        }
        [HttpPost]
        public ActionResult startquiz(FormCollection fc)
        {
            int dem = 0;

            string correct = null;
            cauhoi cau = new cauhoi();
           List<cauhoi> cauhoi = (List<cauhoi>)Session["cauhoi"];
            //foreach (var cau in cauhoi)
            //{
               
                cau.QA = fc["A"];
               
                cau.QB = fc["B"];
               
                cau.QC = fc["C"];
               
                cau.QD = fc["D"];
            //cau.dethi_id = int.Parse(fc["dethi"]);
            cau.QCorrectAns = fc["caudung"];
                string[] caud = cau.QCorrectAns.Split(',');
               
                if (cau.QA != null)
                {
                string[] a = cau.QA.Split(',');
                for (int i = 0; i < a.Count(); i++)
                    {
                        for (int j = i ; j < caud.Count(); j++)
                        {
                            if (a[i] == caud[j])
                            {
                                TempData["score"] = Convert.ToInt32(TempData["score"]) + 1;
                                TempData["caudung"] = Convert.ToInt32(TempData["caudung"]) + 1;
                                dem++;
                            }
                        }

                    }
                }
                if (cau.QB != null)
                {
                    string[] b = cau.QB.Split(',');
                    for (int i = 0; i < b.Count(); i++)
                    {
                        for (int j = i ; j < caud.Count(); j++)
                        {
                            if (b[i] == caud[j])
                            {
                                TempData["score"] = Convert.ToInt32(TempData["score"]) + 1;
                                TempData["caudung"] = Convert.ToInt32(TempData["caudung"]) + 1;
                                dem++;
                            }
                        }

                    }
                }
                if (cau.QC != null)
                {
                    string[] c = cau.QC.Split(',');
                    for (int i = 0; i < c.Count(); i++)
                    {
                        for (int j = i ; j < caud.Count(); j++)
                        {
                            if (c[i] == caud[j])
                            {
                                TempData["score"] = Convert.ToInt32(TempData["score"]) + 1;
                                TempData["caudung"] = Convert.ToInt32(TempData["caudung"]) + 1;
                                dem++;
                            }
                        }

                    }
                }
                if (cau.QD != null)
                {
                    string[] CAUd = cau.QD.Split(',');
                    for (int i = 0; i < CAUd.Count(); i++)
                    {
                        for (int j = i; j < caud.Count(); j++)
                        {
                            if (CAUd[i]== caud[j])
                            {
                                TempData["score"] = Convert.ToInt32(TempData["score"]) + 1;
                                TempData["caudung"] = Convert.ToInt32(TempData["caudung"]) + 1;
                                dem++;
                              
                            }
                            
                        }

                    }
                }

            //break;
            //cau.dethi_id = Convert.ToInt32(fc["dethi"]);

            //if (tachchuoi != null)
            //    {
            //        correct = "A";

            //    }
            //    else if (cau.QB != null)
            //    {
            //        correct = "B";

            //    }
            //    else if (cau.QC != null)
            //    {
            //        correct = "C";

            //    }
            //    else if (cau.QD != null)
            //    {
            //        correct = "D";

            //    }
            //if (cau.QCorrectAns != null)
            //{
            //    TempData["dem"] = Convert.ToInt32(TempData["dem"]) + 1;
            //    if (correct.Equals(cau.QCorrectAns))
            //    {
            //        TempData["score"] = Convert.ToInt32(TempData["score"]) + 1;
            //        TempData["caudung"] = Convert.ToInt32(TempData["caudung"]) + 1;
            //    }




            //}


            //int cou = Convert.ToInt32(TempData["examid"]);
            //int count = db.cauhois.Count(x => x.dethi_id == cou);
            //TempData["count"] = Convert.ToInt32(count);
            //if (Convert.ToUInt32(TempData["caudung"]) == count)
            //{

            string pthi = Convert.ToString(TempData["phongthi"]);
            dethi d = db.dethis.Where(x=>x.phongthi_id==pthi).SingleOrDefault();
            ketqua k = new ketqua();
            k.dethi_id = d.dethi_id;
            k.caudung = Convert.ToInt32(TempData["caudung"]);
            k.diem = Convert.ToInt32(TempData["score"]);
            k.std_id = Convert.ToInt32(Session["std_id"]);
            db.ketquas.Add(k);
            db.SaveChanges();
            //}

            //return RedirectToAction("examDashbroad");
            //TempData.Keep();
            //}
            //cauhoi cc = new cauhoi();
            //cc.dethi_id=Convert.ToInt32(fc["dethi"]);
            return RedirectToAction("endEXAM");
            return View();
        }
        //public ActionResult startquiz(int p) {
        //    dethi d = db.dethis.Where(x => x.phongthi_id == p).SingleOrDefault();
        //    List<cauhoi> cauhoi = db.cauhois.Where(x => x.dethi_id == d.dethi_id).ToList();
        //    TempData["cauhoii"] = cauhoi.ToList();
        //    return View();
        //}
        //public ActionResult startquiz()
        //{
        //    if (Session["std_id"] == null)
        //    {
        //        return RedirectToAction("slogin");
        //    }
        //    cauhoi q = null;
        //    if (TempData["quest"] != null)
        //    {
        //        Queue<cauhoi> qlist = (Queue<cauhoi>)TempData["quest"];
        //        //List<cauhoi> qlist = (List<cauhoi>)TempData["quest"];
        //        if (qlist.Count > 0)
        //        {
        //            q = qlist.Peek();
        //            qlist.Dequeue();
        //            TempData["quest"] = qlist;
        //            TempData.Keep();
        //        }
        //        else
        //        {

        //            return RedirectToAction("endEXAM");
        //        }
        //    }
        //    else
        //    {
        //        return RedirectToAction("examDashbroad");
        //    }
        //    return View(q);
        //}
        //[HttpPost]
        //public ActionResult startquiz(cauhoi q)
        //{
        //    int dem = 0;
           
        //    string correct = null;
           


        //        if (q.QA != null)
        //        {
        //            correct = "A";

        //        }
        //        else if (q.QB != null)
        //        {
        //            correct = "B";

        //        }
        //        else if (q.QC != null)
        //        {
        //            correct = "C";

        //        }
        //        else if (q.QD != null)
        //        {
        //            correct = "D";

        //        }
        //        if (q.QCorrectAns != null)
        //        {
        //            TempData["dem"] = Convert.ToInt32(TempData["dem"]) + 1;
        //            if (correct.Equals(q.QCorrectAns))
        //            {
        //                TempData["score"] = Convert.ToInt32(TempData["score"]) + 1;
        //                TempData["caudung"] = Convert.ToInt32(TempData["caudung"]) + 1;
        //            }




        //        }


        //        int cou = Convert.ToInt32(TempData["examid"]);
        //        int count = db.cauhois.Count(x => x.dethi_id == cou);
        //        TempData["count"] = Convert.ToInt32(count);
        //        if (Convert.ToUInt32(TempData["caudung"]) == count)
        //        {
        //            ketqua k = new ketqua();
        //            k.dethi_id = Convert.ToInt32(TempData["examid"]);
        //            k.caudung = Convert.ToInt32(TempData["caudung"]);
        //            k.diem = Convert.ToInt32(TempData["score"]);
        //            k.std_id = Convert.ToInt32(Session["std_id"]);
        //            db.ketquas.Add(k);
        //            db.SaveChanges();
        //        }
            
        //    //return RedirectToAction("examDashbroad");
        //    TempData.Keep();
        //    return RedirectToAction("startquiz");
        //}
        [HttpGet]
        public ActionResult tlogin()
        {
            return View();
        }
        [HttpPost]
        public ActionResult tlogin(teacher ad)
        {
            teacher ad_admin = db.teachers.Where(x => x.tea_name == ad.tea_name && x.tea_pass == ad.tea_pass).SingleOrDefault();
            if (ad_admin != null)
            {
                Session["adminid"] = ad_admin.tea_id;
                teacher t = db.teachers.Where(x => x.tea_id == ad_admin.tea_id).SingleOrDefault();
                Session["name"] = t.tea_name;
                //if (Session["adminid"] != null)
                //{
                //    ViewBag.ms = "session not null";
                //}
                //else
                //{

                //    return RedirectToAction("Index");

                //}
                return RedirectToAction("Dashbroad");
            }
            else
            {
                ViewBag.ms = "name and pass invaild user";
            }
            return View();
        }
        public ActionResult viewAllquestion(int? id)
        {
            if (Session["tea"] == null)
            {
                return RedirectToAction("tlogin");
            }
            if (id == null)
            {
                return RedirectToAction("Dashbroad");
            }
            return View(db.cauhois.Where(x => x.dethi_id == id).ToList());
        }
        [HttpGet]
        public ActionResult sregister()
        {

            return View();
        }
        [HttpPost]
        public ActionResult sregister(student std, HttpPostedFileBase imgfile)
        {
            student s = new student();
            try
            {
                s.std_name = std.std_name;
                s.std_password = std.std_password;
                s.std_MSSV = std.std_MSSV;
                s.std_email = std.std_email;
                s.std_SDT = std.std_SDT;
                s.std_id = std.std_id;
                s.std_image = "none";
                //s.std_image = uploadImage(imgfile);
                db.students.Add(s);
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            catch (Exception)
            {
                ViewBag.msg = "data could not insert...";
            }

            return View();
        }
        public string uploadImage(HttpPostedFileBase imgfile)
        {
            Random r = new Random();
            string path = "-1";
            int random = r.Next();

            if (imgfile != null && imgfile.ContentLength > 0)
            {
                string extension = Path.GetExtension(imgfile.FileName);
                if (extension.ToLower().Equals(".jgp") || extension.ToLower().Equals(".jpeg") || extension.ToLower().Equals(".png"))
                {
                    try
                    {
                        path = Path.Combine(Server.MapPath("~/Content/img/"), random + Path.GetFileName(imgfile.FileName));
                        imgfile.SaveAs(path);
                        path = "~/Content/img/" + random + Path.GetFileName(imgfile.FileName);





                        //var stream = new FileStream(path, FileMode.Create);
                        //stream.CopyTo(imgfile.InputStream);



                    }
                    catch (Exception ex)
                    {
                        path = "-1";
                    }

                }
                else
                {
                    Response.Write("<script>alert('only jpg,png,jpeg' )</script>");
                }
            }
            else
            {
                Response.Write("<script>alert('please select a file' )</script>");
                path = "-1";
            }


            return path;
        }
        public ActionResult logout()
        {
            Session.Abandon();
            Session.RemoveAll();
            return RedirectToAction("Index");
        }
        public ActionResult endEXAM()
        {
            return View();
        }
        [HttpPost]
        public ActionResult endEXAM(ketqua kq)
        {
            ketqua k = new ketqua();
            k.dethi_id =Convert.ToInt32(TempData["examid"]);
            k.caudung = kq.caudung;
            k.diem = kq.diem;
            k.std_id = Convert.ToInt32(Session["std_id"]);
            db.ketquas.Add(k);
            db.SaveChanges();
            return RedirectToAction("examDashbroad");


           
        }
    }
}