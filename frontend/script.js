// 1. Scalable Initial Jobs Catalog (Easily add more here)
let jobCatalog = [
    { id: 1, company: "Infosys", role: "Java Developer", minPct: 65.0, maxBacklogs: 0, reqYear: 2026, skills: ["Java", "SQL"] },
    { id: 2, company: "TCS", role: "Graduate Engineer", minPct: 70.0, maxBacklogs: 1, reqYear: 2026, skills: ["Java", "HTML"] },
    { id: 3, company: "Wipro", role: "Project Engineer", minPct: 60.0, maxBacklogs: 0, reqYear: 2026, skills: ["Java", "Python"] },
    { id: 4, company: "Accenture", role: "Associate Software Engineer", minPct: 65.0, maxBacklogs: 1, reqYear: 2026, skills: ["Java", "SQL", "Spring"] },
    { id: 5, company: "Capgemini", role: "Software Analyst", minPct: 60.0, maxBacklogs: 0, reqYear: 2026, skills: ["Java", "JavaScript"] },
    { id: 6, company: "IBM", role: "Associate Developer", minPct: 70.0, maxBacklogs: 0, reqYear: 2026, skills: ["Java", "DSA", "SQL"] },
    { id: 7, company: "Cognizant", role: "Programmer Analyst Trainee", minPct: 65.0, maxBacklogs: 1, reqYear: 2026, skills: ["Java", "MySQL"] }
];

// Elements
const jobSelect = document.getElementById("targetJob");
const minPctInput = document.getElementById("minPercentage");
const maxBacklogsInput = document.getElementById("maxBacklogs");
const reqYearInput = document.getElementById("reqYear");
const reqSkillsInput = document.getElementById("reqSkills");

const modalOverlay = document.getElementById("modalOverlay");
const openModalBtn = document.getElementById("openAddJobModalBtn");
const closeModalBtn = document.getElementById("closeModalBtn");
const addJobForm = document.getElementById("addJobForm");

// 2. Populate Dropdown dynamically
function renderJobOptions(selectedId = null) {
    jobSelect.innerHTML = '<option value="">-- Choose a Company & Role --</option>';

    jobCatalog.forEach((job) => {
        const opt = document.createElement("option");
        opt.value = job.id;
        opt.textContent = `${job.company} - ${job.role}`;
        if (selectedId && job.id === selectedId) {
            opt.selected = true;
        }
        jobSelect.appendChild(opt);
    });
}

// 3. Dropdown Change Handler: Auto-fill criteria boxes
jobSelect.addEventListener("change", (e) => {
    const selectedId = parseInt(e.target.value);
    const job = jobCatalog.find((j) => j.id === selectedId);

    if (job) {
        minPctInput.value = job.minPct;
        maxBacklogsInput.value = job.maxBacklogs;
        reqYearInput.value = job.reqYear;
        reqSkillsInput.value = job.skills.join(", ");
    } else {
        minPctInput.value = "";
        maxBacklogsInput.value = "";
        reqYearInput.value = "";
        reqSkillsInput.value = "";
    }
});

// 4. Modal Open/Close Controls
openModalBtn.addEventListener("click", () => modalOverlay.classList.remove("hidden"));
closeModalBtn.addEventListener("click", () => modalOverlay.classList.add("hidden"));
modalOverlay.addEventListener("click", (e) => {
    if (e.target === modalOverlay) modalOverlay.classList.add("hidden");
});

// 5. Add New Company/Job Form Submission
addJobForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const newId = jobCatalog.length > 0 ? Math.max(...jobCatalog.map((j) => j.id)) + 1 : 1;
    const newJob = {
        id: newId,
        company: document.getElementById("newCompany").value.trim(),
        role: document.getElementById("newRole").value.trim(),
        minPct: parseFloat(document.getElementById("newMinPct").value),
        maxBacklogs: parseInt(document.getElementById("newMaxBacklogs").value),
        reqYear: parseInt(document.getElementById("newYear").value),
        skills: document.getElementById("newSkills").value
            .split(",")
            .map((s) => s.trim())
            .filter((s) => s.length > 0)
    };

    jobCatalog.push(newJob);
    renderJobOptions(newJob.id);

    // Trigger change event to fill the inputs with the newly added job
    jobSelect.dispatchEvent(new Event("change"));

    addJobForm.reset();
    modalOverlay.classList.add("hidden");
});

// 6. Candidate Form Evaluation (Mirrors Java OOP Rule Logic)
document.getElementById("eligibilityForm").addEventListener("submit", (e) => {
    e.preventDefault();

    const candidate = {
        name: document.getElementById("name").value.trim(),
        percentage: parseFloat(document.getElementById("percentage").value),
        backlogs: parseInt(document.getElementById("backlogs").value),
        graduationYear: parseInt(document.getElementById("gradYear").value),
        skills: document.getElementById("candidateSkills").value
            .split(",")
            .map((s) => s.trim().toLowerCase())
            .filter((s) => s.length > 0)
    };

    const selectedJobId = parseInt(jobSelect.value);
    const selectedJob = jobCatalog.find((j) => j.id === selectedJobId);

    const jobTarget = {
        company: selectedJob ? selectedJob.company : "Custom",
        role: selectedJob ? selectedJob.role : "Specified Criteria",
        minPercentage: parseFloat(minPctInput.value),
        maxBacklogs: parseInt(maxBacklogsInput.value),
        requiredGraduationYear: parseInt(reqYearInput.value),
        requiredSkills: reqSkillsInput.value
            .split(",")
            .map((s) => s.trim().toLowerCase())
            .filter((s) => s.length > 0)
    };

    // OOP Rule Equivalents
    const pctPass = candidate.percentage >= jobTarget.minPercentage;
    const backlogPass = candidate.backlogs <= jobTarget.maxBacklogs;
    const yearPass = candidate.graduationYear === jobTarget.requiredGraduationYear;
    const skillPass = jobTarget.requiredSkills.every((req) => candidate.skills.includes(req));

    const isEligible = pctPass && backlogPass && yearPass && skillPass;

    // Render UI Outcome
    document.getElementById("placeholderState").classList.add("hidden");
    const resultsContent = document.getElementById("resultsContent");
    resultsContent.classList.remove("hidden");

    document.getElementById("resName").textContent = candidate.name;
    document.getElementById("resJob").textContent = `${jobTarget.company} - ${jobTarget.role}`;

    updateBadge("badgePercentage", pctPass);
    updateBadge("badgeBacklogs", backlogPass);
    updateBadge("badgeYear", yearPass);
    updateBadge("badgeSkills", skillPass);

    const finalBanner = document.getElementById("finalBanner");
    if (isEligible) {
        finalBanner.textContent = "FINAL RESULT: ELIGIBLE";
        finalBanner.className = "final-banner pass";
    } else {
        finalBanner.textContent = "FINAL RESULT: NOT ELIGIBLE";
        finalBanner.className = "final-banner fail";
    }
});

function updateBadge(id, passed) {
    const el = document.getElementById(id);
    el.textContent = passed ? "PASS" : "FAIL";
    el.className = `badge ${passed ? "pass" : "fail"}`;
}

// Initial render of dropdown
renderJobOptions();