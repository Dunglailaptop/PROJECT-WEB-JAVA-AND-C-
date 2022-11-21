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
    public class ketquasController : Controller
    {
        private webtracnghiemonlineEntities1 db = new webtracnghiemonlineEntities1();

        // GET: ketquas
        public ActionResult Index()
        {
            var ketquas = db.ketquas.Include(k => k.dethi).Include(k => k.student);
            return View(ketquas.ToList());
        }

        // GET: ketquas/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ketqua ketqua = db.ketquas.Find(id);
            if (ketqua == null)
            {
                return HttpNotFound();
            }
            return View(ketqua);
        }

        // GET: ketquas/Create
        public ActionResult Create()
        {
            ViewBag.dethi_id = new SelectList(db.dethis, "dethi_id", "dethi_name");
            ViewBag.std_id = new SelectList(db.students, "std_id", "std_name");
            return View();
        }

        // POST: ketquas/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id,std_id,dethi_id,caudung,diem")] ketqua ketqua)
        {
            if (ModelState.IsValid)
            {
                db.ketquas.Add(ketqua);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.dethi_id = new SelectList(db.dethis, "dethi_id", "dethi_name", ketqua.dethi_id);
            ViewBag.std_id = new SelectList(db.students, "std_id", "std_name", ketqua.std_id);
            return View(ketqua);
        }

        // GET: ketquas/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ketqua ketqua = db.ketquas.Find(id);
            if (ketqua == null)
            {
                return HttpNotFound();
            }
            ViewBag.dethi_id = new SelectList(db.dethis, "dethi_id", "dethi_name", ketqua.dethi_id);
            ViewBag.std_id = new SelectList(db.students, "std_id", "std_name", ketqua.std_id);
            return View(ketqua);
        }

        // POST: ketquas/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id,std_id,dethi_id,caudung,diem")] ketqua ketqua)
        {
            if (ModelState.IsValid)
            {
                db.Entry(ketqua).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.dethi_id = new SelectList(db.dethis, "dethi_id", "dethi_name", ketqua.dethi_id);
            ViewBag.std_id = new SelectList(db.students, "std_id", "std_name", ketqua.std_id);
            return View(ketqua);
        }

        // GET: ketquas/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ketqua ketqua = db.ketquas.Find(id);
            if (ketqua == null)
            {
                return HttpNotFound();
            }
            return View(ketqua);
        }

        // POST: ketquas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            ketqua ketqua = db.ketquas.Find(id);
            db.ketquas.Remove(ketqua);
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
