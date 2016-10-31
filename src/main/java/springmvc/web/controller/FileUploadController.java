package springmvc.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    private static final File fileDir = new File( "C:/Uploaded" );

    @RequestMapping(value = "/file/upload.html", method = RequestMethod.GET)
    public String upload()
    {
        return "file/upload";
    }

    @RequestMapping(value = "/file/upload.html", method = RequestMethod.POST)
    public String upload(
        @RequestParam(name = "file") MultipartFile uploadedFile )
        throws IllegalStateException, IOException
    {
        if( !fileDir.exists() ) fileDir.mkdir();

        uploadedFile.transferTo(
            new File( fileDir, uploadedFile.getOriginalFilename() ) );

        return "redirect:upload.html";
    }

    @RequestMapping(value = "/file/download.html", params = "!name")
    public String download( ModelMap models )
    {
        models.put( "names", fileDir.list() );
        return "file/download";
    }

    @RequestMapping("/file/download.html")
    public String download( @RequestParam String name,
        HttpServletResponse response ) throws IOException
    {
        File file = new File( fileDir, name );

        response.setHeader( "Content-Disposition",
            "attachment; filename=" + name );

        FileInputStream in = new FileInputStream( file );
        OutputStream out = response.getOutputStream();
        byte buffer[] = new byte[2048];
        int bytesRead;
        while( (bytesRead = in.read( buffer )) > 0 )
            out.write( buffer, 0, bytesRead );
        in.close();

        return null;
    }

}
