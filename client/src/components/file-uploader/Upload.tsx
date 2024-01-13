import { Button } from "@mui/material";
import Axios from "axios";

export const Upload = () => {
  async function uploadFile() {
    let formData = new FormData();
    formData.append("data", fileupload.files[0]);
    await Axios.post("http://localhost:8080/upload", formData)
      .then((result) => console.log(result))
      .catch((err) => console.error(err));
  }
  return (
    <div>
      <input id="fileupload" type="file" name="fileupload" />
      <Button onClick={uploadFile} variant="contained">
        Upload Photo
      </Button>
    </div>
  );
};
