export type ReactElementProps = {[key: string]: string };

export type ReactElement = {
    type: string|Function;
    props: ReactElementProps;
    children?: ReactElement[];
};

export function createElement(type: string|Function, props: ReactElementProps, ...children: ReactElement[]):ReactElement{
    return {
        type: type, 
        props,
        children
    };
}

export function render({ type,props,children }: ReactElement, container: HTMLElement){
    if(typeof type == "function"){
        render(type(props),container)
    }else{
        const dom = document.createElement(type as string);
        for(let key in props){
            dom[key] = props[key];
        }
        if(children && children.length){
            for(let child of children){
                render(child, dom);
            }
        }
        container.appendChild(dom);
    }
}