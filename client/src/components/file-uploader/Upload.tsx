import { Button } from "@mui/material";
import Axios, { AxiosResponse } from "axios";
import { useState } from "react";
type Props = {
  triggerReload: () => void;
};
type UploadResponse = {
  fileUrl: string;
};
export const Upload = ({ triggerReload }: Props) => {
  const [url, setUrl] = useState<string>("placeholder");

  async function uploadFile() {
    let formData = new FormData();
    formData.append("data", fileupload.files[0]);

    try {
      let response: AxiosResponse<UploadResponse> = await Axios.post(
        "http://localhost:8080/upload2",
        formData,
      );
      let fileUrl = response.data.fileUrl;
      setUrl(fileUrl);
    } catch (err) {
      console.error(err);
    } finally {
    }

    // let formData = new FormData();
    // formData.append("data", fileupload.files[0]);
    // await Axios.post<UploadResponse>("http://localhost:8080/upload2", formData)
    //   .then((response) => setUrl(response.data.fileUrl))
    //   .catch((err) => console.error(err))
    //   .finally(triggerReload());
  }
  return (
    <div>
      <input id="fileupload" type="file" name="fileupload" />
      <img src={url} alt="Uploaded File" style={{ maxWidth: 300 }} />
      <Button
        onClick={() => {
          uploadFile();
        }}
        variant="contained"
      >
        Upload Photo
      </Button>
    </div>
  );
};
