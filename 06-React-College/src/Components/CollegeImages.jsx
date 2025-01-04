import images from "../Utils/Images";

function CollegeImages() {
  return (
    <div>
      <div className="flex flex-wrap gap-5 justify-center mt-3">
        {/* Using the image links */}
        <img src={images.gehu} alt="Graphic Era Hill University" className="imageStyle" />
        <img src={images.uttranchal} alt="Uttranchal University" className="imageStyle" />
        <img src={images.delhiIIT} alt="Delhi IIT" className="imageStyle" />
        <img src={images.puneDAV} alt="Pune DAV" className="imageStyle" />
        <img src={images.RIMC} alt="R.I.M.C" className="imageStyle" />
      </div>
    </div>
  );
}

export default CollegeImages;