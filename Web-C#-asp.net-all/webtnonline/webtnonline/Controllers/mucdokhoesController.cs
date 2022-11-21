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
    public class mucdokhoesController : Controller
    {
        private webtracnghiemonlineEntities1 db = new webtracnghiemonlineEntities1();

        // GET: mucdokhoes
        public ActionResult Index()
        {
            return View(db.mucdokhoes.ToList());
        }

        // GET: mucdokhoes/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            mucdokho mucdokho = db.mucdokhoes.Find(id);
            if (mucdokho == null)
            {
                return HttpNotFound();
            }
            return View(mucdokho);
        }

        // GET: mucdokhoes/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: mucdokhoes/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id_dokho,tendokho")] mucdokho mucdokho)
        {
            if (ModelState.IsValid)
            {
                db.mucdokhoes.Add(mucdokho);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(mucdokho);
        }

        // GET: mucdokhoes/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            mucdokho mucdokho = db.mucdokhoes.Find(id);
            if (mucdokho == null)
            {
                return HttpNotFound();
            }
            return View(mucdokho);
        }

        // POST: mucdokhoes/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id_dokho,tendokho")] mucdokho mucdokho)
        {
            if (ModelState.IsValid)
            {
                db.Entry(mucdokho).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(mucdokho);
        }

        // GET: mucdokhoes/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            mucdokho mucdokho = db.mucdokhoes.Find(id);
            if (mucdokho == null)
            {
                return HttpNotFound();
            }
            return View(mucdokho);
        }

        // POST: mucdokhoes/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            mucdokho mucdokho = db.mucdokhoes.Find(id);
            db.mucdokhoes.Remove(mucdokho);
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
