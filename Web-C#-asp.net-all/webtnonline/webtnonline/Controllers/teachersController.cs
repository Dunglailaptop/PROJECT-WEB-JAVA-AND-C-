using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using webtnonline.Models;

namespace webtnonline.Controllers
{
    public class teachersController : Controller
    {
        private webtracnghiemonlineEntities1 db = new webtracnghiemonlineEntities1();

        // GET: teachers
        public ActionResult Index()
        {
            var teachers = db.teachers.Include(t => t.accadmin1);
            return View(teachers.ToList());
        }

        // GET: teachers/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            teacher teacher = db.teachers.Find(id);
            if (teacher == null)
            {
                return HttpNotFound();
            }
            return View(teacher);
        }

        // GET: teachers/Create
        public ActionResult Create()
        {
            ViewBag.accadmin = new SelectList(db.accadmins, "id", "username");
            return View();
        }

        // POST: teachers/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(teacher t)
        {
            teacher tea = new teacher();
            tea.tea_name = t.tea_name;
            tea.tea_pass = t.tea_pass;
            tea.tea_diachi = t.tea_diachi;
            tea.tea_email = t.tea_email;
            tea.tea_SDT = t.tea_SDT;
            tea.hoten = t.hoten;
            tea.tea_image = "none";
            tea.pq_id = "giao";
            tea.accadmin = 1;
            db.teachers.Add(tea);
            db.SaveChanges();
            return View();
        }

        // GET: teachers/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            teacher teacher = db.teachers.Find(id);
            if (teacher == null)
            {
                return HttpNotFound();
            }
            ViewBag.accadmin = new SelectList(db.accadmins, "id", "username", teacher.accadmin);
            return View(teacher);
        }

        // POST: teachers/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "tea_id,tea_name,tea_pass,tea_SDT,tea_diachi,tea_email,hoten,tea_image,pq_id,accadmin")] teacher teacher)
        {
            if (ModelState.IsValid)
            {
                db.Entry(teacher).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.accadmin = new SelectList(db.accadmins, "id", "username", teacher.accadmin);
            return View(teacher);
        }

        // GET: teachers/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            teacher teacher = db.teachers.Find(id);
            if (teacher == null)
            {
                return HttpNotFound();
            }
            return View(teacher);
        }

        // POST: teachers/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            teacher teacher = db.teachers.Find(id);
            db.teachers.Remove(teacher);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
