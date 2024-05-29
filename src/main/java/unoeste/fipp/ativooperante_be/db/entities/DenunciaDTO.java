package unoeste.fipp.ativooperante_be.db.entities;

import java.util.Date;

public class DenunciaDTO {
    private String titulo;
    private String texto;
    private int urgencia;
    private Date data;
    private Long orgaoId;
    private Long tipoId;
    private Long usuarioId;

    public DenunciaDTO(){
        this("", "", 0, null, 0L, 0L, 0L);
    }
    public DenunciaDTO(String titulo, String texto, int urgencia, Date data, Long orgaoId, Long tipoId, Long usuarioId) {
        this.titulo = titulo;
        this.texto = texto;
        this.urgencia = urgencia;
        this.data = data;
        this.orgaoId = orgaoId;
        this.tipoId = tipoId;
        this.usuarioId = usuarioId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getOrgaoId() {
        return orgaoId;
    }

    public void setOrgaoId(Long orgaoId) {
        this.orgaoId = orgaoId;
    }

    public Long getTipoId() {
        return tipoId;
    }

    public void setTipoId(Long tipoId) {
        this.tipoId = tipoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
