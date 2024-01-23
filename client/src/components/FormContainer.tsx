import { useState } from "react";
import useFetch from "../hooks/useFetch";
import { Display } from "./Display";
import { Forms } from "./Forms";
import { Upload } from "./file-uploader/Upload";

export const FormContainer = () => {
  const [field, setField] = useState<string>("");
  const { loading, data, triggerReload } = useFetch(
    "http://localhost:8080/photos",
  );
  return (
    <>
      <Display
        field={field}
        setField={setField}
        data={data}
        loading={loading}
      />
      <Forms field={field} setField={setField} triggerReload={triggerReload} />
      <Upload triggerReload={triggerReload} />
    </>
  );
};
